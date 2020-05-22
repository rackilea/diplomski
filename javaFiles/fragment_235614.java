import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Main {

    public static void main(String[] args) {
        String line = "This cat MAN-1243-23445 placed  OK? This cat MAN-1243-23445 placed  OK? This cat MAN-1243-23445 placed  OK? This cat MAN-1243-23445 placed  OK?This cat MAN-1243-23445 placed  OK? This cat MAN-1243-23445 placed  OK?";
        String pattern = "(MAN-\\d{4}-\\d{5})"; // The 2 and 3 match only for digit
        // Create a Pattern object
        Pattern r = Pattern.compile(pattern);

        // Now create matcher object.
        Matcher m = r.matcher(line);
        //first Occurrence
        /*if (m.find( )) {
            System.out.println("Found value: " + m.group() );
        }else {
            System.out.println("NO MATCH");
        }*/
        //For all the occurrence
        while(m.find( )) {
            System.out.println("Found value: " + m.group(0));
        }

    }
}