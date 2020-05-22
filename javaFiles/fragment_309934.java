public void add(Appointment a) 
{
    if (dateValidate(a)){
        appointmentCalender.add(a);
    }else{
    System.out.println("Invalid Date");
    }
}

public boolean dateValidate(Appointment a){

    if(a.getAppointmentDate().getStartTime().after(a.getAppointmentDate().getAppDate())){
        if(a.getAppointmentDate().getEndTime().after(a.getAppointmentDate().getStartTime())){
            return true;
        }
    }
    return false;
}