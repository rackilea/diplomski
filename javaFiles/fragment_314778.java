import java.text.ParseException;
import java.text.SimpleDateFormat;

public class User {

    private SimpleDateFormat inputFormat = new SimpleDateFormat("ddMMyyyy");
    private SimpleDateFormat outputFormat = new SimpleDateFormat("dd MMM yyyy");
    private String firstName;
    private String lastName;
    private String birthDate;
    private String birthPlace;

    public User(String[] user) throws ParseException {
        this(user[0], user[1], user[2], user[3]);
    }

    public User(String firstName, String lastName, String birthDate, String birthPlace) throws ParseException {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = outputFormat.format(inputFormat.parse(birthDate));
        this.birthPlace = birthPlace;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    @Override
    public String toString() {
        return "User [firstName=" + firstName + ", lastName=" + lastName
                + ", birthDate=" + birthDate + ", birthPlace=" + birthPlace
                + "]\n";
    }
}