class Appointment implements Comparable<Appointment> {
    private int patientId;
    private LocalDateTime appointmentDate;

    // Getters & setters

    @Override
    public int compareTo(final Appointment other) {
        return appointmentDate.compareTo(other.appointmentDate);
    }
}