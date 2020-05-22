import java.util.ArrayList;
import java.util.HashMap;

public class StringT {


public static void main(String[] args) {

    // alpha would represent fetchContactNames()
    ArrayList<String> alpha = new ArrayList<String>();
    // bravo would represent fetchContactNumbers()
    HashMap<String, String> bravo = new HashMap<String, String>();
    // charlie would represent newList
    ArrayList<String> charlie = new ArrayList<String>();

    bravo.put("1", "One"); charlie.add("5");
    bravo.put("2", "Two"); charlie.add("1");
    bravo.put("3", "Three"); charlie.add("3");
    bravo.put("4", "Four"); charlie.add("4");
    bravo.put("5", "Five"); charlie.add("2");

    // this will print charlie just as you see above
    for(int i = 0; i < charlie.size(); i ++){
        System.out.println(charlie.get(i));
    }

    System.out.println("---------------------");

    // this will print charlie with the numbers replaced as names
    for(int i = 0; i < charlie.size(); i++){
        String value;
        if((value = bravo.get(charlie.get(i))) != null){
            charlie.set(i, value);
        }
    }

    for(int i = 0; i < charlie.size(); i ++){
        System.out.println(charlie.get(i));
    }
}
}