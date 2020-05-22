mport java.io.Serializable;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TT {

    /**
     * @param args
     * @throws Exception 
     * @throws Exception 
     */
    public static Timestamp getCurrentDateAndTime() throws Exception
    {
        String strFormat = new String("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat formatter = new SimpleDateFormat(strFormat);
        java.util.Date theDate = new java.util.Date();
        theDate = (java.util.Date) formatter.parse(formatter.format(theDate));
        Timestamp rtnTS = new Timestamp(theDate.getTime());
        return rtnTS;
    }
    public static void main(String[] args) throws Exception {

        InvoiceObject i=new InvoiceObject();
        System.out.println(i.getmTimeIssued());
        }

}
class InvoiceObject extends java.lang.Object implements Serializable
{
    public Integer mId;
    public Timestamp mTimeIssued;

    public InvoiceObject()
    {
           // this.mId = new Long("0");
            Timestamp tempTime;
            try {
                tempTime = TT.getCurrentDateAndTime();
                  this.mTimeIssued = tempTime;
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } //successful
       //here throwing error
    }
    public Timestamp getmTimeIssued() {
        return mTimeIssued;
    }
}