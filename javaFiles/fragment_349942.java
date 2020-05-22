import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.google.common.base.CaseFormat;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

public class AccessorBasedTypeAdaptor<T> extends TypeAdapter<T> {

  private Gson gson;

  public AccessorBasedTypeAdaptor(Gson gson) {
    this.gson = gson;
  }

  @SuppressWarnings("unchecked")
  @Override
  public void write(JsonWriter out, T value) throws IOException {
    out.beginObject();
    for (Method method : value.getClass().getMethods()) {
      boolean nonBooleanAccessor = method.getName().startsWith("get");
      boolean booleanAccessor = method.getName().startsWith("is");
      if ((nonBooleanAccessor || booleanAccessor) && !method.getName().equals("getClass") && method.getParameterTypes().length == 0) {
        try {
          String name = method.getName().substring(nonBooleanAccessor ? 3 : 2);
          name = CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_CAMEL, name);
          Object returnValue = method.invoke(value);
          if(returnValue != null) {
            TypeToken<?> token = TypeToken.get(returnValue.getClass());
            TypeAdapter adapter = gson.getAdapter(token);
            out.name(name);
            adapter.write(out, returnValue);
          }
        } catch (Exception e) {
          throw new ConfigurationException("problem writing json: ", e);
        }
      }
    }
    out.endObject();
  }

  @Override
  public T read(JsonReader in) throws IOException {
    throw new UnsupportedOperationException("Only supports writes.");
  }
}