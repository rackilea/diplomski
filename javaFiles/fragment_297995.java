import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator;

import java.math.BigDecimal;

public class JsonApp {

    public static void main(String[] args) throws Exception {
        YAMLFactory yamlFactory = new YAMLFactory();
        yamlFactory.disable(YAMLGenerator.Feature.USE_NATIVE_TYPE_ID);

        ObjectMapper mapper = new ObjectMapper(yamlFactory);

        serialiseAndDeserialise(mapper, new MyValue());
        serialiseAndDeserialise(mapper, new MyBigDecimal());
    }

    private static void serialiseAndDeserialise(ObjectMapper mapper, MyInterface myInterface) throws java.io.IOException {
        MyClass myClass = new MyClass();
        myClass.setInstance(myInterface);

        String yaml = mapper.writeValueAsString(myClass);
        System.out.println(yaml);
        System.out.println(mapper.readValue(yaml, MyClass.class));
    }
}

class MyClass {

    @JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, property = "name")
    private MyInterface instance;

    public MyInterface getInstance() {
        return instance;
    }

    public void setInstance(MyInterface instance) {
        this.instance = instance;
    }

    @Override
    public String toString() {
        return "MyClass{" +
                "instance=" + instance +
                '}';
    }
}

interface MyInterface {
}

class MyValue implements MyInterface {
    private int value = 42;
    private String category = "fancy";

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "MyValue{" +
                "value=" + value +
                ", category='" + category + '\'' +
                '}';
    }
}

class MyBigDecimal implements MyInterface {
    private BigDecimal pi = BigDecimal.valueOf(Math.PI);

    public BigDecimal getPi() {
        return pi;
    }

    public void setPi(BigDecimal pi) {
        this.pi = pi;
    }

    @Override
    public String toString() {
        return "MyBigDecimal{" +
                "pi=" + pi +
                '}';
    }
}