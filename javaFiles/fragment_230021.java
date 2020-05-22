import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
class Demo{
    public static void main(String[]args)throws ParseException{
        final String input="Mar-2016";
        final SimpleDateFormat fmt=new SimpleDateFormat("MMM-yyyy");//same as above format
        Date date=fmt.parse(input);
        final Calendar cal=Calendar.getInstance();//as of now
        cal.setTime(date);//set to input
        final int month=cal.get(Calendar.MONTH);//gives index 0 - 11, Jan - Dec
        List<String> dates=new ArrayList<>();
        do{
            cal.add(Calendar.MONTH,1);//adds month one-by-one
            date=cal.getTime();//give date 
            dates.add(fmt.format(date));//date to string as per above format
        }while(month!=cal.get(Calendar.MONTH));//unitl next year of given input month
        System.out.println(dates);
    }
}