import java.util.regex.*;

public class ExpectedJSON{

     public static void main(String []args){
        String string = "{\"employee\":[{\"address\":\"New Delhi\",\"employeeId\":\"22222\",\"employeeName\":\"Abhishek\",\"jobType\":\"Marketing\",\"salary\":\"50000\"},{\"address\":\"Noida\",\"employeeId\":\"11111\",\"employeeName\":\"Dineh Rajput\",\"jobType\":\"Sr.Software Engineer\",\"salary\":\"70000\"}]}";
        String regex = "^[^\\[]+(.+)\\}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(string);

        matcher.find();
        String group = matcher.group(1);

        System.out.println(group);
     }
}