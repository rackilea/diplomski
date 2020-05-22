import org.apache.lucene.document.Document;
import org.apache.lucene.index.LeafReader;
import org.apache.lucene.index.LeafReaderContext;
import org.apache.lucene.search.SimpleCollector;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


final class AllDocumentsCollector extends SimpleCollector {

  private final List<Document> documents;
  private LeafReader currentReader;

  public AllDocumentsCollector(final int numDocs) {
    this.documents = new ArrayList<>(numDocs);
  }

  public List<Document> getDocuments() {
    return Collections.unmodifiableList(documents);
  }

  @Override
  protected void doSetNextReader(final LeafReaderContext context) {
    currentReader = context.reader();
  }

  @Override
  public void collect(final int doc) throws IOException {
    documents.add(currentReader.document(doc));
  }

  @Override
  public boolean needsScores() {
    return false;
  }
}