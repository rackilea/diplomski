import java.util.*;

public class main{
    public static void main(String[] args){
        Map<String, Node> customMap = new HashMap<String, Node>();
        customMap.put("MyFilename", new Node("Violation 1", "Some Data"));
        System.out.println("This is a test of the custom Node: " + customMap.get("MyFilename").getViolationType());
    }
}