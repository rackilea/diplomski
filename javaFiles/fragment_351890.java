import com.fasterxml.jackson.annotation.*;

import java.awt.Rectangle;

public class JacksonHelper {

    // Don't call any functions when serializing or deserializing.
    // Only look at the public class variables.
    @JsonAutoDetect(getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE,
            fieldVisibility = JsonAutoDetect.Visibility.PUBLIC_ONLY
    )
    public static abstract class RectangleMixin {}

    // Don't call any functions when serializing or deserializing.
    // Only look at the class variables of any visibility (including private)
    @JsonAutoDetect(getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE,
            fieldVisibility = JsonAutoDetect.Visibility.ANY
    )
    public static abstract class WordMixin {
        @JsonCreator
        public WordMixin(@JsonProperty("text") String text, @JsonProperty("confidence") float confidence,
                         @JsonProperty("boundingBox") Rectangle boundingBox) {}
    }

}