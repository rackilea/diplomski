public class Entry {

    private String Username, Firstname, Lastname, Email, Gender, Race, ID, SSN;

    public Entry(String Username, String Firstname, String Lastname, String Email, String Gender, String Race, String ID, String SSN) {
        this.Username = Username;
        this.Firstname = Firstname;
        this.Lastname = Lastname;
        this.Email = Email;
        this.Gender = Gender;
        this.Race = Race;
        this.ID = ID;
        this.SSN = SSN;
    }

    @Override
    public String toString() {
        return ("Username:" + this.Username);
    }
}