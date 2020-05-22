import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.type.CollectionType;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

public class JsonApp {

    public static void main(String[] args) throws Exception {
        File jsonFile = new File("./resource/test.json").getAbsoluteFile();

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        JsonNode jsonNode = mapper
                .reader()
                .at("/result/result")
                .readTree(new FileInputStream(jsonFile));

        CollectionType productsType = mapper.getTypeFactory().constructCollectionType(List.class, Product.class);
        List<Product> products = mapper.convertValue(jsonNode, productsType);
        System.out.println(products);
    }
}