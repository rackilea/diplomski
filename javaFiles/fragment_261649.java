@Controller
public class AppointmentsController {

    @RequestMapping(value="/appointments/{day}", method = RequestMethod.GET)
    public Map<String, Appointment> getForDay(@PathVariable int day) {
        ...
    }

    @RequestMapping(value="/appointments/new")
    public AppointmentForm getNewForm() {
        ...
    }
}