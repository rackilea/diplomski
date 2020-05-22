package stackoverflow.questions.q19332412;

import java.io.IOException;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.*;

public class BoxAdapter extends TypeAdapter<Box>
{

    @Override
    public void write(JsonWriter out, Box box) throws IOException {
        out.beginObject();
        out.name("w");
        out.value(box.width);
        out.name("d");
        out.value(box.depth);
        out.name("h");
        out.value(box.height);
        out.endObject();
    }

    @Override
    public Box read(JsonReader in) throws IOException {
        if (in.peek() == JsonToken.NULL) {
            in.nextNull();
            return null;
          }

        in.beginObject();
        Box box = new Box();
        while (in.peek() == JsonToken.NAME){
            String str = in.nextName();
            fillField(in, box, str);
        }

        in.endObject();
        return box;
    }

    private void fillField(JsonReader in, Box box, String str)
            throws IOException {
        switch(str){
            case "w": 
            case "width": 
                box.width = in.nextInt();
            break;
            case "h":
            case "height": 
                box.height = in.nextInt();
            break;
            case "d": 
            case "depth":
                box.depth = in.nextInt();
            break;
        }
    }
}