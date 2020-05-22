import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

public class ArrayAdapterFactory implements TypeAdapterFactory {

    @Override
    @SuppressWarnings({"unchecked", "rawtypes"})
    public <T> TypeAdapter<T> create(final Gson gson, final TypeToken<T> type) {

        TypeAdapter<T> typeAdapter = null;
        try {
            if (type.getRawType() == List.class || type.getRawType() == ArrayList.class) {

                typeAdapter = new ArrayAdapter(gson,
                        (Class) ((ParameterizedType) type.getType())
                                .getActualTypeArguments()[0]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return typeAdapter;

    }

}