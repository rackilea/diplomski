import java.util.ArrayList;


public class Marklength {

    void marklength4(ArrayList <String> themarklength){
        for(String n : themarklength){
            if(n.length() ==4){
                themarklength.add("****");
            }
        }
        System.out.println(themarklength);
    }
}