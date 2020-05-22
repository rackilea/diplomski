import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.List;

public class JsonApp {

    public static void main(String[] args) throws Exception {
        File jsonFile = new File("./resource/test.json").getAbsoluteFile();

        ObjectMapper mapper = new ObjectMapper();
        Root root = mapper.readValue(jsonFile, Root.class);
        System.out.println(root);
    }
}

class Root {

    private Class1 class1;

    //getters, setters, toString
}

class Class1 {

    private String prop1;
    private List<NestedProps> prop2;

    //getters, setters, toString
}

class NestedProps {

    private List<NestedProp> nestedProp;

    //getters, setters, toString
}

class NestedProp {
    private String p1;
    private String p2;

    //getters, setters, toString
}