import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class JsonApp {

    public static void main(String[] args) throws Exception {
        File jsonFile = new File("./resource/test.json").getAbsoluteFile();

        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(MapperFeature.ALLOW_COERCION_OF_SCALARS);

        System.out.println(mapper.readValue(jsonFile, Pojo.class));
    }
}

class Pojo {

    private int id;
    private Boolean isValid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Boolean getIsValid() {
        return isValid;
    }

    public void setIsValid(Boolean valid) {
        isValid = valid;
    }

    @Override
    public String toString() {
        return "Pojo{" +
                "id=" + id +
                ", isValid=" + isValid +
                '}';
    }
}