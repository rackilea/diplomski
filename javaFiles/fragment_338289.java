import java.util.Date;

public class MiMiMi {

    public static void main(String[] args) {

        String input = "/Date(-588657600000-0400)/";
        input = input.replace("/Date(", "");
        input = input.replace(")/", "");

        String[] pair = input.split("-");
        System.out.println(pair[1]);
        System.out.println(pair[2]);

        Date foo = new Date(Long.parseLong("-" + pair[1])
                + Long.parseLong("-" + pair[2]));

        System.out.println(foo);
    }

}