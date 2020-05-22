import java.text.DecimalFormat;

import org.eclipse.persistence.mappings.foundation.AbstractTransformationMapping;
import org.eclipse.persistence.mappings.transformers.AttributeTransformer;
import org.eclipse.persistence.mappings.transformers.FieldTransformer;
import org.eclipse.persistence.sessions.Record;
import org.eclipse.persistence.sessions.Session;

public class FixedFloatingTransformer implements FieldTransformer, AttributeTransformer { 
  private AbstractTransformationMapping mapping;
  private static DecimalFormat FORMAT = new DecimalFormat("0.00000000");

  public Object buildAttributeValue(Record r, Object obj, Session arg2) {
    return r.get(mapping.getFields().get(0));
  }

  public Object buildFieldValue(Object instance, String xpath, Session session) {
    Object o2 = mapping.getAttributeValueFromObject(instance);
    if (o2 instanceof Number) {
      return ((DecimalFormat)FORMAT.clone()).format((Number)o2);
    }
    return null;
  }

  public void initialize(AbstractTransformationMapping mapping) {
    this.mapping = mapping;
  }
}