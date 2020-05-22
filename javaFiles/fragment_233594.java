private static AppointmentService appointments;

@Autowired
public void setAppointments(AppointmentService appointments){
    ApplicationServer.appointments = appointments;
}