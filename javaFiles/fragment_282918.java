import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.concurrent.*;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.*;
import org.apache.lucene.index.*;
import org.apache.lucene.search.*;
import org.apache.lucene.store.FSDirectory;

public class LucenePeriodicCommitRefreshExample {
    ScheduledExecutorService scheduledExecutor;
    MyIndexer indexer;
    MySearcher searcher;

    void init() throws IOException {
        scheduledExecutor = Executors.newScheduledThreadPool(3);
        indexer = new MyIndexer();
        indexer.init();
        searcher = new MySearcher(indexer.indexWriter);
        searcher.init();
    }

    void destroy() throws IOException {
        searcher.destroy();
        indexer.destroy();
        scheduledExecutor.shutdown();
    }

    class MyIndexer {
        IndexWriter indexWriter;
        Future commitFuture;

        void init() throws IOException {
            indexWriter = new IndexWriter(FSDirectory.open(Paths.get("C:\\Temp\\lucene-example")), new IndexWriterConfig(new StandardAnalyzer()));
            indexWriter.deleteAll();
            for (int i = 1; i <= 100000; i++) {
                add(String.valueOf(i), "whatever " + i);
            }
            indexWriter.commit();
            commitFuture = scheduledExecutor.scheduleWithFixedDelay(() -> {
                try {
                    indexWriter.commit();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }, 5, 5, TimeUnit.MINUTES);
        }

        void add(String id, String text) throws IOException {
            Document doc = new Document();
            doc.add(new StringField("id", id, Field.Store.YES));
            doc.add(new StringField("text", text, Field.Store.YES));
            indexWriter.addDocument(doc);
        }

        void update(String id, String text) throws IOException {
            indexWriter.deleteDocuments(new Term("id", id));
            add(id, text);
        }

        void destroy() throws IOException {
            commitFuture.cancel(false);
            indexWriter.close();
        }
    }

    class MySearcher {
        IndexWriter indexWriter;
        SearcherManager searcherManager;
        Future maybeRefreshFuture;

        public MySearcher(IndexWriter indexWriter) {
            this.indexWriter = indexWriter;
        }

        void init() throws IOException {
            searcherManager = new SearcherManager(indexWriter, true, null);
            maybeRefreshFuture = scheduledExecutor.scheduleWithFixedDelay(() -> {
                try {
                    searcherManager.maybeRefresh();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }, 0, 5, TimeUnit.SECONDS);
        }

        String findText(String id) throws IOException {
            IndexSearcher searcher = null;
            try {
                searcher = searcherManager.acquire();
                TopDocs topDocs = searcher.search(new TermQuery(new Term("id", id)), 1);
                return searcher.doc(topDocs.scoreDocs[0].doc).getField("text").stringValue();
            } finally {
                if (searcher != null) {
                    searcherManager.release(searcher);
                }
            }
        }

        void destroy() throws IOException {
            maybeRefreshFuture.cancel(false);
            searcherManager.close();
        }
    }

    public static void main(String[] args) throws IOException {
        LucenePeriodicCommitRefreshExample example = new LucenePeriodicCommitRefreshExample();
        example.init();
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                try {
                    example.destroy();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter a document id to update (from 1 to 100000): ");
            String id = scanner.nextLine();
            System.out.print("Enter what you want the document text to be: ");
            String text = scanner.nextLine();
            example.indexer.update(id, text);
            long startTime = System.nanoTime();
            String foundText;
            do {
                foundText = example.searcher.findText(id);
            } while (!text.equals(foundText));
            long elapsedTimeMillis = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startTime);
            System.out.format("it took %d milliseconds for the searcher to see that document %s is now '%s'\n", elapsedTimeMillis, id, text);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.exit(0);
        }
    }
}