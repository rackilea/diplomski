import java.lang.*;
import java.lang.reflect.*;
import java.util.*;
import javax.swing.*;

public class main
{
    public static void main(String ...args) {
        Object o = new JRadioButton();
        Class cl;
        HashSet methodsnames = new HashSet();

        for (cl = o.getClass(); cl != null; cl = cl.getSuperclass()) {
           HashSet al = new HashSet();
           System.out.println(cl.getName()+ " - ");
           for (Method m : cl.getDeclaredMethods()){
               boolean added = methodsnames.add(m.getName());
               if(added){
                   al.add(m.getName());
               }
           }
           al.forEach(System.out::println);

           System.out.println("=============================");
        }
    }
}