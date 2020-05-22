import java.text.SimpleDateFormat;
import java.util.Date;



public class Test{

    public static void main(String[] args) {
        long val = 1346524199000l;
        Date date=new Date(val);
        SimpleDateFormat df2 = new SimpleDateFormat("dd/MM/yy");
        String dateText = df2.format(date);
        System.out.println(dateText);
    }
}