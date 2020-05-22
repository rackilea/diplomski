public class AppointmentTest {

    static int year = 2015;
    static int month = 3;
    static int day = 15;

    public static void main(String[] args) {

        AppointmentBook book = new AppointmentBook();
        book.addAppointment(new Appointment())
        .addAppointment(new OneTime())
        .addAppointment(new Appointment())
        .addAppointment(new OneTime());

        for (Appointment item: AppointmentBook.apps) {

            if (item instanceof OneTime) {
                boolean checkOnce = ((OneTime)item).occursOn(month, day,    year);

                if (checkOnce == true) {
                    System.out.println("We have a checked OneTime     instance...");
                } else {
                    System.out.println("We have an unchecked OneTime     instance...");
                }
            } else {
                System.out.println("Not a OneTime instance...");
            }           
        }       
    }
}