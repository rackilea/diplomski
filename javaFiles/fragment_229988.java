import java.io.IOException;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;

public class JsonXmlTransformation {

    public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
        System.out.println(jsonToXml());
    }

    /**
     * json to xml transformation 
     */
    public static String jsonToXml() throws JsonParseException, JsonMappingException, IOException{
        String json = "{\r\n      \"field1\": \"value1\",\r\n      \"field2\": \"value2\",\r\n      \"field3\": \"value3\",\r\n      \"field4\": \"value4\",\r\n      \"field5\": \"value5\"\r\n    }";
        return new XmlMapper().writeValueAsString(new ObjectMapper().readValue(json, Message.class));
    }
}

class Message {

    @JacksonXmlProperty(localName = "element1")
    String element1;

    @JacksonXmlProperty(localName = "element2")
    String element2;

    @JacksonXmlProperty(localName = "element3")
    Elements elements;

    @JsonCreator
    public Message(@JsonProperty("field1") String element1, @JsonProperty("field2") String element2,
            @JsonProperty("field3") String element3, @JsonProperty("field4") String element4, @JsonProperty("field5") String element5) {
        super();
        this.element1 = element1;
        this.element2 = element2;
        this.elements = new Elements(element3, element4, element5); 
    }
}

class Elements{

    public Elements(String element3, String element4, String element5) {
        super();
        this.element3 = element3;
        this.element4 = element4;
        this.element5 = element5;
    }

    @JacksonXmlText
    String element3;

    @JacksonXmlProperty(localName = "element4", isAttribute = true)
    String element4;

    @JacksonXmlProperty(localName = "element5", isAttribute = true)
    String element5;
}