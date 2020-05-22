import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.InstanceCreator;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.EnumMap;

public class JsonApp {

    enum FRUIT {
        APPLE, BANANA
    }

    enum Apple {
        LIGOL,
        MUTSU
    }

    public static void main(String[] args) {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(EnumMap.class, new InstanceCreator<EnumMap>() {
                    @Override
                    public EnumMap createInstance(Type type) {
                        Type[] types = (((ParameterizedType) type).getActualTypeArguments());
                        return new EnumMap((Class<?>) types[0]);
                    }
                })
                .create();

        String jsonString = "{ \"BANANA\":\"tasty!\", \"APPLE\":\"gross!\" }";
        String jsonString1 = "{ \"LIGOL\":\"red!\", \"MUTSU\":\"green!\" }";

        Type enumMap1 = new TypeToken<EnumMap<FRUIT, String>>() {}.getType();
        System.out.println(gson.fromJson(jsonString, enumMap1).toString());

        Type enumMap2 = new TypeToken<EnumMap<Apple, String>>() {}.getType();
        System.out.println(gson.fromJson(jsonString1, enumMap2).toString());
    }
}