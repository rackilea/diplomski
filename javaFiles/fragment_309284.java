import java.util.Date;
import java.text.SimpleDateFormat;

public class SDF {
    public static final void main(String[] args) {
        SimpleDateFormat localDateFormat = new SimpleDateFormat("HH:mm:ss");
        String time = localDateFormat.format(new Date());
        System.out.println(time);
    }
}