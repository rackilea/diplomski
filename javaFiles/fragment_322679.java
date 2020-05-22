void printAppointment(Appointment a) throws ParseException {
    System.out.println(a.getSummary());
    System.out.println(a.getDescription());

    System.out.println(formatter.format(a.getStartTime().getTime()));
    System.out.println(formatter.format(a.getEndTime().getTime()));
    System.out.println(a.getAppointmentGroup());
    System.out.println(a.getLocation());


    System.out.println("Days difference = " + daysBetween(a.getStartTime().getTimeInMillis(), a.getEndTime().getTimeInMillis()));
}

private int daysBetween(long t1, long t2) {
    return (int) ((t2 - t1) / (1000 * 60 * 60 * 24));
}