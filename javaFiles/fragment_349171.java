import java.util.TimeZone ;

public class Test {
    public static void main(String[] args) throws Exception {
        TimeZone zone = TimeZone.getDefault();
        System.out.println(zone.getDisplayName());
        System.out.println(zone.getID());
    }
}