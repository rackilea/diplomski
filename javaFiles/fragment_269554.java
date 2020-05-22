import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class QuickTester {

    public static void main(String[] args) {

        ArrayList<String> test = 
                new ArrayList<String>(Arrays.asList(
                        "Adam", "Bob", "Catherine", "Dylan"));

        StringBuilder sb = new StringBuilder();
        Iterator<String> stringIterator = test.iterator();
        while(stringIterator.hasNext()) {

            sb.append(stringIterator.next());

            if(stringIterator.hasNext()) {
                sb.append(", ");
            }
        }

        System.out.println(sb.toString());
    }
}