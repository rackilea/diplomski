import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.Date;
import java.text.ParseException;

String input = "2014-12-20 10:22:12 PM";
//Format of the date defined in the input String
DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss aa");
//Desired format: 24 hour format: Change the pattern as per the need
DateFormat outputformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
Date date = null;
String output = null;
try{
   //Converting the input String to Date
   date= df.parse(input);
   //Changing the format of date and storing it in String
   output = outputformat.format(date);
   //Displaying the date
   System.out.println(output);
} catch (ParseException pe) {
   pe.printStackTrace();
}