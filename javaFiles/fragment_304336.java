package json;

import java.lang.reflect.Field;
import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

public class App {

    public static void main(String[] args) {
        Gson gson = new GsonBuilder().registerTypeAdapter(
                MyAnnotationBean.class,
                new AnnotatedDeserializer<MyAnnotationBean>()).create();

        String json = "{\"desc\":\"This is desc\",\"country\":\"this is country\"}";
        MyAnnotationBean tab = gson.fromJson(json, MyAnnotationBean.class);
        System.out.println(tab.desc);
        System.out.println(tab.country);

        json = "{\"desc\":\"This is desc\"}";
        tab = gson.fromJson(json, MyAnnotationBean.class);
        System.out.println(tab.desc);
        System.out.println(tab.country);

        json = "{\"country\":\"This is country\"}";
        tab = gson.fromJson(json, MyAnnotationBean.class);
        System.out.println(tab.desc);
        System.out.println(tab.country);
    }
}


class MyAnnotationBean {
    public String desc;
    public String country;
}

class AnnotatedDeserializer<T> implements JsonDeserializer<T> {

    public T deserialize(JsonElement je, Type type,
            JsonDeserializationContext jdc) throws JsonParseException {
        T obj = new Gson().fromJson(je, type);

        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field f : fields) {
                try {
                    f.setAccessible(true);
                    if (f.get(obj) == null) {
//                       throw new JsonParseException("required json " +
//                       f.getName());

                        // add your code to know missing fields
                    }
                } catch (IllegalArgumentException ex) {
                    ex.printStackTrace();
                } catch (IllegalAccessException ex) {
                    ex.printStackTrace();
                }
        }
        return obj;

    }
}