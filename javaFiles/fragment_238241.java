import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.text.ParseException;
class Main{
   public static void main(String args[]){
    String oldDate = "2019-07-1";  
    System.out.println("Date before Addition: "+oldDate);
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    Calendar c = Calendar.getInstance();
    try{
       c.setTime(sdf.parse(oldDate));
    }catch(ParseException e){
        e.printStackTrace();
     }

    c.add(Calendar.DAY_OF_MONTH, 32);  
    String newDate = sdf.format(c.getTime());  
    System.out.println("Date after Addition: "+newDate);
   }
}