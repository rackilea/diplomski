import org.openjdk.jol.info.GraphLayout;

public class MainClass {

    public static void main(String[] args) {

        String city = "Chicago";

        byte[] cityByte = "Chicago".getBytes();

        System.out.println(GraphLayout.parseInstance(city).toPrintable());
        System.out.println(GraphLayout.parseInstance(cityByte).toPrintable());
    }
}