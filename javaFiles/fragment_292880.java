public class TestCalendar {

public static void main(String[] args){
    Calendar c = Calendar.getInstance();
    int unique_id = Integer.parseInt("" + c.get(Calendar.HOUR) + c.get(Calendar.MINUTE)
            + c.get(Calendar.SECOND));

    System.out.println(unique_id);
}
}