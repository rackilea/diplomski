import java.text.SimpleDateFormat;
import java.util.Date;

import org.eclipse.persistence.mappings.foundation.AbstractTransformationMapping;
import org.eclipse.persistence.mappings.transformers.FieldTransformer;
import org.eclipse.persistence.sessions.Session;

public class TimeFieldTransformer implements FieldTransformer {

    private AbstractTransformationMapping mapping;
    private SimpleDateFormat HHmmss = new SimpleDateFormat("HHmmss");

    public void initialize(AbstractTransformationMapping mapping) {
        this.mapping = mapping;
    }

    public Object buildFieldValue(Object instance, String xPath, Session session) {
        Date date = (Date) mapping.getAttributeValueFromObject(instance);
        return HHmmss.format(date);
    }

}