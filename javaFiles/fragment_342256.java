import java.util.ArrayList;


public class Marklength {

    ArrayList<String> marklength4(ArrayList <String> themarklength){
        ArrayList<String> markedStrings = new ArrayList<String>(themarklength.size());
        for(String n : themarklength){
            if(n.length() ==4){
                markedStrings.add("****");
            }
            markedStrings.add(n);
        }
        System.out.println(themarklength);
        return markedStrings;
    }
}