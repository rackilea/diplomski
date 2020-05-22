@JsonCreator
public Appointment(@JsonProperty("craeted_at") Time craeted_at, @JsonProperty("appointment_date") Date appointment_date,
        @JsonProperty("name_of_doctor") String name_of_doctor, @JsonProperty("status") boolean status, @JsonProperty("price") double price) {
    this.craeted_at = craeted_at;
    this.appointment_date = appointment_date;
    this.name_of_doctor = name_of_doctor;
    this.status = status;
    this.price = price;
}