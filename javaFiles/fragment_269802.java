import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
    public static void main(String[] args) {
        String result1 = mapDate("201802"+"00");
        System.out.print("result: " + result1 + "\n");
        String result2 = mapDate("201702"+"02");
        System.out.print("result: " + result2 + "\n");
        String result3 = mapDate("201802"+"02");
        System.out.print("result: " + result3);
    }

    public static String mapDate(String value){
        String myDate;
        myDate = "";
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy");
        String thisYear = format1.format(new Date());
        if(!value.substring(value.length() - 2).equals("00") && value.substring(0, 4).equals(thisYear))
            myDate = "01/" + value.substring(4, 6) + "/" + value.substring(0, 4) + " 12:00";
        return myDate;
    }
}