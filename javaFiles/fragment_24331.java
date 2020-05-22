import com.owlike.genson.Context;
import com.owlike.genson.Converter;
import com.owlike.genson.stream.ObjectReader;
import com.owlike.genson.stream.ObjectWriter;

public class DemoConverter implements Converter<Demo> {

  @Override
  public void serialize(Demo demo, ObjectWriter objectWriter, Context context) {
    objectWriter.beginObject();
    objectWriter.writeString("name", demo.getName());
    demo.getMp().forEach((prop, value) ->
      objectWriter.writeString(prop, value)
    );
    objectWriter.endObject();
  }

  @Override
  public Demo deserialize(ObjectReader objectReader, Context context) throws Exception {
    // TODO
  }

}