import java.util.*;
import java.time.*;
import java.time.format.*;

public class HelloWorld{

     public static void main(String []args){
        OffsetDateTime odtB = OffsetDateTime.parse("2019-02-02T13:55:00Z");
        DateTimeFormatter f = DateTimeFormatter.ISO_OFFSET_DATE_TIME;
        System.out.print(f.format(odtB)); // 2019-02-02T13:55:00Z
     }
}