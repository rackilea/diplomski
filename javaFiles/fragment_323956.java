import java.io.File;
    import java.io.FileWriter;
    import java.io.IOException;

    import org.apache.lucene.document.Document;
    import org.apache.lucene.index.IndexReader;
    import org.apache.lucene.queryparser.classic.ParseException;
    import org.apache.lucene.store.Directory;
    import org.apache.lucene.store.FSDirectory;
    import org.apache.solr.client.solrj.SolrServerException;

    public class SomeClass {

        public static void main(String[] args) throws IOException {


            Directory dirIndex = FSDirectory.open(new File("solr/home/data/index"));
            IndexReader indexReader = IndexReader.open(dirIndex);
            Document doc = null;   

            for(int i = 0; i < indexReader.numDocs(); i++) {
                doc = indexReader.document(i);
            }

            System.out.println(doc.toString());

            indexReader.close();
            dirIndex.close();
        }
   }