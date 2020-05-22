import java.util.Arrays;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

class Tuple {
    private Integer key;
    private String value;

    public Tuple(Integer key, String value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return "(" + key + ", " + value + ")";
    }
}

class HtmlDocument {

    private int docId;
    private String URL;
    private List<String> terms;

    public int getDocId() {
        return docId;
    }

    public void setDocId(int docId) {
        this.docId = docId;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public List<String> getTerms() {
        return terms;
    }

    public void setTerms(List<String> terms) {
        this.terms = terms;
    }

    public String getWordFrequency(String word) {
        return "query";
    }
}

class IndexingTask implements Runnable {

    private ConcurrentHashMap<String, Vector<Tuple>> dictionary;
    private HtmlDocument document;

    public IndexingTask(ConcurrentHashMap<String, Vector<Tuple>> dictionary,
                        ConcurrentHashMap<Integer, String> sources, HtmlDocument document) {
        this.dictionary = dictionary;
        this.document = document;
        sources.putIfAbsent(document.getDocId(), document.getURL());
    }

    @Override
    public void run() {

        for (String word : document.getTerms()) {

            this.dictionary.computeIfAbsent(word, k -> new Vector<Tuple>())
                    .add(new Tuple(document.getDocId(), document.getWordFrequency(word)));

        }
        Crawler.RUNNING_TASKS.decrementAndGet();
    }
}

class Crawler {

    protected BlockingQueue<HtmlDocument> finishedPages = new LinkedBlockingQueue<>();

    public static final AtomicInteger RUNNING_TASKS = new AtomicInteger();

    public BlockingQueue<HtmlDocument> getFinishedPages() {
        return finishedPages;
    }
}

public class ConcurrentHashMapExample {

    private ConcurrentHashMap<Integer, String> sources = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, Vector<Tuple>> dictionary = new ConcurrentHashMap<>();

    private static final ExecutorService INDEXING_SERVICE = Executors.newSingleThreadExecutor();

    public void run(Crawler crawler) throws InterruptedException {
        while (!crawler.getFinishedPages().isEmpty()) {
            Crawler.RUNNING_TASKS.incrementAndGet();
            this.INDEXING_SERVICE.submit(new IndexingTask(this.dictionary, sources,
                    crawler.getFinishedPages().take()));
        }
        //when you call ```this.INDEXING_SERVICE.shutdown()``` may 'IndexingTask' has not run yet
        while (Crawler.RUNNING_TASKS.get() > 0)
            Thread.sleep(3);
        this.INDEXING_SERVICE.shutdown();
    }

    public ConcurrentHashMap<Integer, String> getSources() {
        return sources;
    }

    public ConcurrentHashMap<String, Vector<Tuple>> getDictionary() {
        return dictionary;
    }

    public static void main(String[] args) throws Exception {
        ConcurrentHashMapExample example = new ConcurrentHashMapExample();
        Crawler crawler = new Crawler();
        HtmlDocument document = new HtmlDocument();
        document.setDocId(1);
        document.setURL("http://127.0.0.1/abc");
        document.setTerms(Arrays.asList("hello", "world"));
        crawler.getFinishedPages().add(document);
        example.run(crawler);
        System.out.println("source: " + example.getSources());
        System.out.println("dictionary: " + example.getDictionary());
    }

}