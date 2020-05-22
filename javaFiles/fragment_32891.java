import java.util.ArrayList;
import java.util.List;

public class AppointmentBook {

    public static List<Appointment> apps = new ArrayList<Appointment>();

    public AppointmentBook addAppointment(Appointment app) {
        apps.add(app);
        return this;
    }

}