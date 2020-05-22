import com.fasterxml.jackson.databind.ObjectMapper;

import java.awt.*;
import java.io.IOException;

public class WordTest {
    public static void main(String[] args) throws IOException {
        ObjectMapper om = new ObjectMapper();
        om.addMixIn(Rectangle.class, JacksonHelper.RectangleMixin.class);
        om.addMixIn(Word.class, JacksonHelper.WordMixin.class);

        Word word = new Word("t1", 12, new Rectangle(1, 3));
        String ser = om.writeValueAsString(word);
        Word r = om.readValue(ser, Word.class);
        System.out.println(ser);
        // {"text":"t1","confidence":12.0,"rect":{"x":0,"y":0,"width":1,"height":3}}
    }
}