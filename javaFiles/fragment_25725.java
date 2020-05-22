import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class Element {

    String customer;
    Date date;
    String company;
    static SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss yyyy");

    void setDate(String date) {
        try {
            this.date = sdf.parse(date);
        } catch (ParseException ex) {
            // Do something if parsing fails
        }
    }

    @Override
    public String toString() {
        return "<customer," + customer + ">\n"
                + "<Date," + sdf.format(date) + ">\n"
                + "<company," + company + ">";
    }
}

public class ParseList {

    public static void main(String args[]) {
        List<String> list = new ArrayList<>();

        list.add("[customer=dan, Date=Wed Sep 16 06:42:18  1938,company=abbc]");
        list.add("[customer=ben, Date=Sun May 19 13:12:51  1956,company=tss]");

        List<Element> elementList = new ArrayList<>();
        for (String str : list) {
            String[] arr = str.split("[,\\]]"); // Split the string
            Element element = new Element();
            element.customer = arr[0].split("=")[1]; // Split again on the equals
            element.setDate(arr[1].split("=")[1]);
            element.company = arr[2].split("=")[1];
            elementList.add(element);
        }

        for (Element element : elementList) {
            System.out.println(element);
        }

    }
}