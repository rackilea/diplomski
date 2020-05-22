import java.util.*;

public class ListThreads {

     public static void main(String []args){
        Set<Thread> threadSet = Thread.getAllStackTraces().keySet();
        for (Thread t : threadSet) {
            System.out.println (t.getName());
        }
     }
}