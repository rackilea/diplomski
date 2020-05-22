import java.util.*;
import java.io.PrintStream;

public class KeyValueSwitcher {

    public static void main(String[]args) {
        PrintStream output=new PrintStream(System.out);
        Scanner input=new Scanner(System.in);


        Map<String, String>normal=new HashMap<String, String>();

        output.println("Enter your map, one key-value pair per line,");
        output.println("comma-separated. Use empty line as sentinel.");

        for(String entry=input.nextLine();entry.length()!=0;
        entry=input.nextLine()) {
            int comma=entry.indexOf(",");
            String key=entry.substring(0,comma);
            String value=entry.substring(comma+1);
            normal.put(key,value);

        }
        output.println(normal);

        Map<String, String>reverse=new HashMap<String, String>();

        for(Map.Entry<String, String>entry:normal.entrySet()) {

            String keyY=entry.getKey();
            String valueE=entry.getValue();
            // check to see if we've already put an entry in the reverse map for this key.
            String existingReverseValue = reverse.get(valueE);
            if(existingReverseValue != null) {
                // We have, so let's see if the value is greater or less
                int currentValue = Integer.parseInt(existingReverseValue);
                int potentialNewValue = Integer.parseInt(keyY);
                if(potentialNewValue < currentValue) {
                    // Old reverse value is greater, so replace with new reverse value
                    reverse.put(valueE, keyY);
                }
            } else {
                // No previous reverse value exists, so add new reverse value
                reverse.put(valueE,keyY);
            }
        }
        output.println(reverse);
    }
}