import java.text.*;
import java.util.*;
class TestFormatDate {


public static void main(String arg[]) throws Exception{

String s = "04/17/2017 06:46:53 -0600";
SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss Z");
Date value = format.parse(s);
System.out.println("value "+value); 
}
}