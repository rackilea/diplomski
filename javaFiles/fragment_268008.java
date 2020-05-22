public class User {
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String dob;
    private double height;
    private double weight;
    private String gender;

    public User() {}

    public User(String email, String password, String firstName, String lastName, String dob, double height, double weight, String gender) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.height = height;
        this.weight = weight;
        this.gender = gender;
    }

    public String getEmail() {return email;}

    public String getPassword() {return password;}

    public String getFirstName() {return firstName;}

    public String getLastName() {return lastName;}

    public String getDob() {return dob;}

    public double getHeight() {return height;}

    public double getWeight() {return weight;}

    public String getGender() {return gender;}
}