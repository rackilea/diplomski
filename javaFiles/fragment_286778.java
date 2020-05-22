import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

enum MyEnum {
    HELLO, WORLD
}


public class SerializableObject implements Serializable {
    @Enumerated(EnumType.STRING)
    private MyEnum       singleValue;
    // What annotation do I put here?
    @Enumerated(EnumType.ORDINAL)
    private List<MyEnum> multiValue;


    public void show() {

        multiValue = new ArrayList<>(Arrays.asList(MyEnum.values()));
        multiValue.stream().forEach(
                element -> System.out.println(element.ordinal() + " " + element.toString()));
    }


    public static void main(String[] args) {

        new SerializableObject().show();
    }
}