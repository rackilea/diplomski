import java.util.*;

public class ans{
    public static void main(String[] args){
    Bears bears = new Bears();
    bears.add(new Bear());
    bears.add(new Bear());
    bears.add(new Bear());

    System.out.println(bears);
    }
}

class Bear{
    public String toString(){
    return "I am a bear";
    }
}

class Bears{
    private ArrayList<Bear> bears = new ArrayList<Bear>();

    public void add(Bear bear){
    bears.add(bear);
    }

    public String toString(){
    StringBuilder str = new StringBuilder();
    if(!bears.isEmpty()){ // If there is no bears, return empty string
        str.append(bears.get(0)); // Append the first one
        for(int index = 1; index < bears.size(); index++){ // For all others
        str.append(" - "); // Append a separator and the bear string
        str.append(bears.get(index));
        }

    }
    return str.toString();
    }
}