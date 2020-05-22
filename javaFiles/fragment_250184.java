import org.apache.lucene.document.Field;
import org.apache.lucene.document.LongField;
import org.apache.lucene.document.NumericDocValuesField;
import org.apache.lucene.document.SortedDocValuesField;
import org.apache.lucene.document.StringField;
import org.apache.lucene.util.BytesRef;

document.add(new StringField(fieldName, stringContent, Field.Store.NO));
document.add(new SortedDocValuesField(fieldName, new BytesRef(stringContent)));
// OR
document.add(new LongField(fieldName, longValue, Field.Store.NO));
document.add(new NumericDocValuesField(fieldName, longValue));