import java.util.*;

public class HelloWorld{

     public static void main(String []args){
        Map<Integer,String>test = new HashMap<Integer,String>();
        test.put(1,"Sridhar");
        test.put(2,"Lord Balaji");
        test.put(3,"Ragavendra");
        test.put(4,"Jai Krishna");
        Set testObject = test.keySet();
        LinkedList<Integer> normal = new LinkedList<Integer>();
        Deque<Integer> interfaceImpl = new LinkedList<Integer>(); //Here Design principle works
        interfaceImpl.addAll(testObject);
        System.out.println(interfaceImpl);
        System.out.println("The keys are:"+interfaceImpl.getFirst());
        normal.addAll(testObject);
        System.out.println(normal);
        System.out.println("The keys are:"+normal.getFirst());
     }
}