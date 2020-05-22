import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.List;

@JacksonXmlRootElement(localName = "web-request-form")
public class Test {
    @JsonProperty("attachments")
    public Attachments attachments;

    public static class Attachments {
        // @JacksonXmlElementWrapper(localName = "attachment")
        @JacksonXmlElementWrapper(useWrapping = false, localName = "attachment")
        public List<Attachment> attachment;

        // ...
    }

    public static class Attachment {
        @JsonProperty("filename")
        public String fileName;

        @JsonProperty("desc")
        public String desc;

        @JsonProperty("size")
        public String size;

        // ...
    }
}