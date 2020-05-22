import org.apache.lucene.index.LeafReaderContext;
import org.apache.lucene.index.SortedDocValues;
import org.apache.lucene.search.SimpleCollector;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


final class AllDocumentsCollector extends SimpleCollector {

  private final List<String> documents;
  private final String fieldName;
  private SortedDocValues docValues;

  public AllDocumentsCollector(final String fieldName, final int numDocs) {
    this.fieldName = fieldName;
    this.documents = new ArrayList<>(numDocs);
  }

  public List<String> getDocuments() {
    return Collections.unmodifiableList(documents);
  }

  @Override
  protected void doSetNextReader(final LeafReaderContext context) throws IOException {
    docValues = context.reader().getSortedDocValues(fieldName);
  }

  @Override
  public void collect(final int doc) throws IOException {
    documents.add(docValues.get(doc).utf8ToString());
  }

  @Override
  public boolean needsScores() {
    return false;
  }
}