public static void main(String[] args){
  Date yourDate = new Date("Monday",2,1993); //the date object which you already have
  Time yourTime = new Time(5,6); // the time object that you already have

  Appointment yourAppointment = new Appointment(); //creating an empty Appointment object
  yourAppointment.setDate(yourDate); //setting your created date in appointment
  yourAppointment.setTime(yourTime); //setting your created time in appointment
}