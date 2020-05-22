import javax.swing.JOptionPane;
import java.util.*;

public class DialogTimer{
    public static void main(String args[]){
        int time1, time2, milli1, milli2, sec1, sec2, timeDifference;
        final int MILLISECSINSECOND =1000;

        GregorianCalendar before=new GregorianCalendar();
        milli1=before.get(GregorianCalendar.MILLISECOND);

        JOptionPane.showConfirmDialog(null, "Is stealing ever justified? ");

        GregorianCalendar after= new GregorianCalendar();
        milli2=after.get(GregorianCalendar.MILLISECOND);


        sec1=before.get(GregorianCalendar.SECOND);
        sec2=after.get(GregorianCalendar.SECOND);

        time1=MILLISECSINSECOND * sec1 + milli1;
        time2=MILLISECSINSECOND * sec2 + milli2;


        //timeDifference=time1 - time2;
        System.out.println(time1);
        System.out.println(time2);


        //JOptionPane.showMessageDialog(null, "It took " + (time1 - time2) + " milliseconds for you to answer");


    }

}