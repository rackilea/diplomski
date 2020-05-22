import java.util.*;

public class Main {
    private static ArrayList<Class1> allInstances = new ArrayList<Class1>();

    public static void main(String[] args)
    {
        Map <String, String> var = new HashMap<String, String>();
        var.put("key1","value1");
        Class1 instance1 = new Class1(var);
        allInstances.add(instance1);

        var = new HashMap<String, String>();
        var.put("key2","value2");
        Class1 instance2 = new Class1(var);
        allInstances.add(instance2);

        getInstances();
    }

    public static void getInstances() {
        for(Class1 c: allInstances) 
            System.out.println(c.getClassDetails());
    }
}