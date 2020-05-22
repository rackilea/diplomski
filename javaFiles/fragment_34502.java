import com.ca.training.rest.server.config.DateTimeAdapter;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.Serializable;
import java.time.LocalDateTime;

import static com.ca.training.rest.server.config.DateTimeAdapter.DATE_FORMAT;

@XmlRootElement
public class RestObject implements Serializable {

    private LocalDateTime timestamp;
    private String title;
    private String fullText;
    private Long id;
    private Double value;

    @XmlJavaTypeAdapter(DateTimeAdapter.class)
    @JsonFormat(pattern = DATE_FORMAT)
    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    //Other getters and setters.
}