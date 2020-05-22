import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

@Component
 public class LocalizedTextSerializer extends StdSerializer<LocalizedText> {

     private static final long serialVersionUID = 619043384446863988L;

    @Autowired
    I18nUtil messages;

    public LocalizedTextSerializer() {
        super(LocalizedText.class);
    }

    public LocalizedTextSerializer(Class<LocalizedText> t) {
        super(t);
    }

    @Override
    public void serialize(LocalizedText value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeString(messages.get(value.getText()));
    }

}