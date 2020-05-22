import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.Version;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.module.SimpleModule;
import org.junit.Test;
import java.io.IOException;

public class JacksonSerializerTest {

    @Test
    public void test() throws Exception {
        C c = new C("initially lowercase string in c");
        B b = new B(c);
        A a = new A(b);

        SimpleModule module = new SimpleModule("MyCustomModule", new Version(1, 0, 0, null));
        module.addSerializer(new CustomSerializerForC());

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(module);

        String pretty = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(a);
        System.out.println(pretty);
    }

    public class A {
        private B b;

        public A(B b) {
            this.b = b;
        }

        public B getB() {
            return b;
        }

        public void setB(B b) {
            this.b = b;
        }
    }

    public class B {
        private C c;

        public B(C c) {
            this.c = c;
        }

        public C getC() {
            return c;
        }

        public void setC(C c) {
            this.c = c;
        }
    }

    public class C {
        private String value;

        public C(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }

    public class CustomSerializerForC extends JsonSerializer<C> {

        @Override
        public Class<C> handledType() {
            return C.class;
        }

        @Override
        public void serialize(C c, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
            String upperCase = c.getValue().toUpperCase();
            jsonGenerator.writeString(upperCase);
        }
    }
}