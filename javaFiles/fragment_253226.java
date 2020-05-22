import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.eclipse.persistence.internal.helper.DatabaseField;
import org.eclipse.persistence.mappings.foundation.AbstractTransformationMapping;
import org.eclipse.persistence.mappings.transformers.AttributeTransformer;
import org.eclipse.persistence.sessions.Record;
import org.eclipse.persistence.sessions.Session;

public class DateAttributeTransformer implements AttributeTransformer {

    private AbstractTransformationMapping mapping;
    private SimpleDateFormat yyyyMMddHHmmss = new SimpleDateFormat("yyyyMMddHHmmss");

    public void initialize(AbstractTransformationMapping mapping) {
        this.mapping = mapping;
    }

    public Object buildAttributeValue(Record record, Object instance, Session session) {
        try {
            String dateString = null;
            String timeString = null;

            for(DatabaseField field : mapping.getFields()) {
                if(field.getName().contains("DATE")) {
                    dateString = (String) record.get(field);
                } else {
                    timeString = (String) record.get(field);
                }
            }
            return yyyyMMddHHmmss.parseObject(dateString + timeString);
        } catch(ParseException e) {
            throw new RuntimeException(e);
        }
    }

}