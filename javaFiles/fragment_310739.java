import java.util.ArrayList;
import java.util.List;

public class PrintList {


    public static void main(String[] args) {


        List<String> s1 = AClass.getSource();

        for (String dk : s1) {
            System.out.println("We have : " + dk);
        }
    }
}

class AClass {
    public static final ArrayList<String> sourceList = new ArrayList<String>();

    static {
        sourceList.add("A string");
        sourceList.add("Another string");        
    }

    public static ArrayList<String> getSource() {
        return sourceList;
    }
}