@Entity
public class Appointment {


//    id
//    created_at
//    appointment_date
//    name_of_doctor
//    status (Available or Booked)
//    price

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private java.sql.Time craeted_at;

    @Column
    private java.sql.Date appointment_date;

    @Column
    private String name_of_doctor;

//    @Column
//    private Boolean status;

    @Embedded
    private Status status;

    @Column
    private double price;

    public Appointment() {

    }

    @JsonCreator
    public Appointment(@JsonProperty("craeted_at") Time craeted_at, @JsonProperty("appointment_date") Date appointment_date,
                       @JsonProperty("name_of_doctor") String name_of_doctor, @JsonProperty("status") Status status, @JsonProperty("price") double price) {

        this.craeted_at = craeted_at;
        this.appointment_date = appointment_date;
        this.name_of_doctor = name_of_doctor;
        this.status = status;
        this.price = price;
    }

    public Appointment(String name_of_doctor, Status status, double price) {

        this.name_of_doctor = name_of_doctor;
        this.status = status;
        this.price = price;
    }

    public Appointment(String name_of_doctor, double price) {

        this.name_of_doctor = name_of_doctor;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Time getCraeted_at() {
        return craeted_at;
    }

    public void setCraeted_at(Time craeted_at) {
        this.craeted_at = craeted_at;
    }

    public Date getAppointment_date() {
        return appointment_date;
    }

    public void setAppointment_date(Date appointment_date) {
        this.appointment_date = appointment_date;
    }

    public String getName_of_doctor() {
        return name_of_doctor;
    }

    public void setName_of_doctor(String name_of_doctor) {
        this.name_of_doctor = name_of_doctor;
    }

    public Status isStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Appointment)) return false;
        Appointment that = (Appointment) o;
        return Double.compare(that.getPrice(), getPrice()) == 0 &&
                Objects.equals(getId(), that.getId()) &&
                Objects.equals(getCraeted_at(), that.getCraeted_at()) &&
                Objects.equals(getAppointment_date(), that.getAppointment_date()) &&
                Objects.equals(getName_of_doctor(), that.getName_of_doctor()) &&
                Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId(), getCraeted_at(), getAppointment_date(), getName_of_doctor(), status, getPrice());
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", craeted_at=" + craeted_at +
                ", appointment_date=" + appointment_date +
                ", name_of_doctor='" + name_of_doctor + '\'' +
                ", status=" + status +
                ", price=" + price +
                '}';
    }
}




import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Status {

    @Column(name = "status")
    Boolean status;

    public Status() {
    }

    public Status(Boolean status) {
        this.status = status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}