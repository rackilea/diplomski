import java.util.HashMap;
import java.util.Map;

public class ChildClassTypeA extends ParentClass<TypeA> {

    @Override
    void extract() {
        Map<String,TypeA> myMap=new HashMap<>();
        setMap(myMap);
    }

    @Override
    void validate() {

    }
}