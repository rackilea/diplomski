import java.lang.reflect.Field;
import java.util.Map;
import java.util.HashMap;

public class FieldTest {

    String name;
    String id;


    public static void main(String[] args) {
        new FieldTest();
    }

    public FieldTest() {
    Map<String,String> variablesMap = new HashMap<String,String>();
    variablesMap.put("name","Joshi");
    variablesMap.put("id","101");

    for (Map.Entry<String, String> entry : variablesMap.entrySet())
    {
        try {
        test(entry.getKey(),entry.getValue());
        }
        catch(NoSuchFieldException ex) {
            ex.printStackTrace();
        }
        catch(IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    System.out.println(name);
    System.out.println(id);
    }

    private void test(String name, String value) throws NoSuchFieldException, IllegalAccessException {
        Field field = getClass().getDeclaredField(name);
        field.set(this,value);
    }

}