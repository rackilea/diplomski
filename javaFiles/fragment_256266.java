import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;

public class Draft {

public static class SomeClass{

    final private String val;

    public SomeClass(String val) {
        this.val = val;
    }
}

public void someFun(String str, SomeClass ... classes) {
    System.out.println("someFun" + str + Arrays.toString(classes));
}

public static void main(String[] args) {
    HashMap<String, String> keyToParam = new HashMap<>();
    keyToParam.put("a", "b");
    keyToParam.put("c", "d");
    String strArg = null;
    SomeClass[] classes = new SomeClass[keyToParam.size()];
    int pointer = 0;
    for(Entry<String, String> entry: keyToParam.entrySet()) {
        strArg += entry.getKey() + ":#";
        classes[pointer++] = new SomeClass(entry.getValue());
    }
    new Draft().someFun(strArg, classes);
}

}