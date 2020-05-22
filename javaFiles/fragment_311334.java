import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.IOException;
import java.util.Date;

public class Main {

    public static void main(String[] args) throws Exception {
        B b = new B();
        b.setProperty("Value");

        A a = new A();
        a.setB(b);

        ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(a));
    }
}

@JsonSerialize(using = ASerializer.class)
class A {

    private B b;

    public B getB() {
        return b;
    }

    public void setB(B b) {
        this.b = b;
    }
}

class ASerializer extends JsonSerializer<A> {

    @Override
    public void serialize(A value, JsonGenerator gen, SerializerProvider serializers) throws IOException, JsonProcessingException {
        gen.writeStartObject();
        gen.writeStringField("now", new Date().toString());
        gen.writeObjectField("b", value.getB());
        gen.writeEndObject();
    }
}

@JsonSerialize(using = BSerializer.class)
class B {

    private String property;

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }
}

class BSerializer extends JsonSerializer<B> {

    @Override
    public void serialize(B value, JsonGenerator gen, SerializerProvider serializers) throws IOException, JsonProcessingException {
        gen.writeStartObject();
        gen.writeStringField("p", value.getProperty());
        gen.writeEndObject();
    }
}