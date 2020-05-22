import java.util.ArrayList;

public class OOMETest {    
    public static void main(String[] args) 
    {
        ArrayList<ArrayList<Object>> listOfLists = new ArrayList<ArrayList<Object>> ();
        listOfLists.ensureCapacity(Integer.MAX_VALUE);
        while (true) {
            ArrayList<Object> list = new ArrayList<Object>();
            list.ensureCapacity(Integer.MAX_VALUE);
            listOfLists.add(list);
        }
    }
}