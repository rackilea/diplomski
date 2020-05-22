import java.io.IOException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;



public class teste {

    /**
     * @param args
     * @throws IOException 
     */
    public static void main(final String[] args) throws IOException {

        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        try {
            Date data = sdf.parse("21:00:00");

            Time time = new Time(data.getTime());

            System.out.println(time);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}