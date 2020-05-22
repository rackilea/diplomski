public void add(Appointment a){
    if(a==null){
     throw new IllegalArgumentException("appointement can't be null");
    }
    appointmentList.add(a);


}