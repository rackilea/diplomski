import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.time.Instant;

@Getter
@Setter
@ToString
public class TestDto {

    @NotNull
    private String id;

    @NotNull
    @JsonDeserialize(using = InstantDeserializer.class)
    @DateTimeFormat(pattern = "YYYY-MM-DD'T'hh:mm:ss.SSS'Z'")
    private Instant timestamp;
}