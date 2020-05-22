import java.util.*;

public class DateChange {
    public static void main(String[] args) {
        Scanner kbd = new Scanner(System.in);
        String usDate, euDate, day = "", month = "", year = "";
        System.out.println("Enter a date in the form month/day/year:");
        usDate = kbd.nextLine();
        kbd.close();
        month = usDate.substring(0, usDate.indexOf("/"));
        day = usDate.substring(usDate.indexOf("/")+1, usDate.lastIndexOf("/"));
        year = usDate.substring(usDate.lastIndexOf("/")+1, usDate.length());
        euDate = day + "." + month + "." + year;
        System.out.println("Your date in European form is:");
        System.out.println(euDate);
    }
}