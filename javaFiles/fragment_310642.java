public boolean makeAppointment(int time,
                               Appointment appointment)
{
    if(validTime(time)) {
        int startTime = time - START_OF_DAY;
        int duration = appointment.getDuration();
        if(checkMultihourAppointment(startTime, duration)) {
            // Fill in all the slots for the full duration
            // of the appointment.
            for(int i = 0; i < duration; i++) {
                appointments[startTime + i] = appointment;
            }
            return true;
        }
        else {

            return false;
        }
    }
    else {
        return false;
    }
}

private boolean checkMultihourAppointment(int startTime, int duration){
    for(int i = 0; i < duration; i++) {
          if(appointments[startTime + i] != null) return false;
    }
    return true;
}