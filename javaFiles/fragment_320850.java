import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.Fields;
import org.apache.lucene.index.PostingsEnum;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.TermsEnum;
import org.apache.lucene.index.Term;
import org.apache.lucene.index.MultiFields;
import org.apache.lucene.util.BytesRef;
import org.apache.lucene.util.BytesRefBuilder;
import org.apache.lucene.util.NumericUtils;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.search.DocIdSetIterator;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.TotalHitCountCollector;
import org.apache.lucene.util.Bits;
import org.apache.lucene.index.MultiFields;

public class ReadLongTermReferenceCount {

    public static void main(String[] args) throws IOException {

        Directory dirIndex = FSDirectory.open(Paths.get('/path/to/index/'));
        IndexReader indexReader = DirectoryReader.open(dirIndex);
        final BytesRefBuilder bytes = new BytesRefBuilder(); 


        TermsEnum termEnum = MultiFields.getTerms(indexReader, "field").iterator(null);

        IndexSearcher searcher = new IndexSearcher(indexReader);
        TotalHitCountCollector collector = new TotalHitCountCollector();

        Bits liveDocs = MultiFields.getLiveDocs(indexReader);
        final BytesRefBuilder bytes = new BytesRefBuilder(); // for reuse!
        int maxDoc = indexReader.maxDoc();
        int docsPassed = 0;
        for (int i=0; i<maxDoc; i++) {
            if (docsPassed==100) {
                break;
            }
            if (liveDocs != null && !liveDocs.get(i))
                continue;
            Document doc = indexReader.document(i);

            //get longTerm from this doc and convert to BytesRefBuilder
            String longTerm = doc.get("longTerm");
            NumericUtils.longToPrefixCoded(Long.valueOf(longTerm).longValue(),0,bytes);

            //time before the first test
            long time_start = System.nanoTime();

            //look in the "field" index for longTerm and count the number of documents
            int count = 0;
            termEnum.seekExact(bytes.toBytesRef());
            PostingsEnum docsEnum = termEnum.postings(liveDocs, null);
            if (docsEnum != null) {
                int docx;
                while ((docx = docsEnum.nextDoc()) != DocIdSetIterator.NO_MORE_DOCS) {
                    count++;
                }
            }

            //mid point: test 1 done, start of test 2
            long time_mid = System.nanoTime();

            //do a search for longTerm in "field"
            TermQuery query = new TermQuery(new Term("field", bytes.toBytesRef()));
            searcher.search(query,collector);
            int count = collector.getTotalHits();

            //end point: test 2 done.
            long time_end = System.nanoTime();

            //write to stdout
            System.out.println(longTerm+"\t"+(time_mid-time_start)+"\t"+(time_end-time_mid));

            docsPassed++;
        }
        indexReader.close();
        dirIndex.close();
    }
}