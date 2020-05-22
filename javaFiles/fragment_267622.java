import java.io.IOException;
import java.nio.file.Paths;

import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.WildcardQuery;
import org.apache.lucene.store.FSDirectory;



public class LuceneSearcher {

    public static void searchIndex() throws IOException{

        IndexReader reader = DirectoryReader.open(FSDirectory.open(Paths.get("D:\\Experiment")));

        IndexSearcher searcher = new IndexSearcher(reader);

        TopDocs hits = searcher.search(new WildcardQuery(new Term("NAME", "*")), 20);

        if (null == hits.scoreDocs || hits.scoreDocs.length <= 0) {
            System.out.println("No Hits1 Found");
            return;
        }

        System.out.println(hits.scoreDocs.length + " hits1 Docs found !!");

        for (ScoreDoc hit : hits.scoreDocs) {
            Document doc = searcher.doc(hit.doc);
        }

        reader.close();
    }
}