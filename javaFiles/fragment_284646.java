import java.util.ArrayList;
import java.util.List;


public abstract class AbstractPure implements ISomeInterface {
    public static final List<String> days = new ArrayList<String>();
    static{
        days.add("Monday");
        days.add("Tuesday");
        days.add("Wednesday");      
        days.add("Thursday");   
        days.add("Friday"); 
        days.add("Saturday");   
        days.add("Sunday"); 
    }
}