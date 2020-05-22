import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.type.CollectionType;

public class JacksonProgram {

    public static void main(String[] args) throws IOException {
        List<Data> datas = new ArrayList<Data>(10);
        for (int index = 0; index < 10; index++) {
            Data data = new Data();
            data.setId(index);
            data.setValue(index < 6 ? Data.DEFAULT_VALUE : index);
            datas.add(data);
        }
        System.out.println(datas);

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(datas);

        System.out.println(json);

        CollectionType collectionType = mapper.getTypeFactory().constructCollectionType(ArrayList.class, Data.class);
        List<Data> deserializedArray = mapper.readValue(json, collectionType);

        System.out.println(deserializedArray);
    }
}