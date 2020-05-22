import java.util.*;
import java.text.*;

public class Test {

    public static void main(String[] args) throws Exception {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        format.setLenient(false);
        Date date = format.parse("2011-06-1211"); // Throws...
        System.out.println(date);
    }
}