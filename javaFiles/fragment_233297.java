@Entity
@Table(name = "person")
@Access(AccessType.PROPERTY)
public class Person implements Serializable {

    private IntegerProperty id;
    private StringProperty firstName;
    private StringProperty lastName;
    private IntegerProperty age;
    private StringProperty address;

    public Person() {
    }

    public Person(int id, String firstName, String lastName, int age, String address) {
        this.id = new SimpleIntegerProperty(id);
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
        this.age = new SimpleIntegerProperty(age);
        this.address = new SimpleStringProperty(address);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public int getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id = new SimpleIntegerProperty(id);
    }

    public IntegerProperty idProperty() {
        return id;
    }

    @Column(name = "firstname")
    public String getFirstName() {
        return firstName.get();
    }

    public void setFirstName(String firstName) {
        this.firstName = new SimpleStringProperty(firstName);
    }

    public StringProperty firstNameProperty() {
        return firstName;
    }

    @Column(name = "lastname")
    public String getLastName() {
        return lastName.get();
    }

    public void setLastName(String lastName) {
        this.lastName = new SimpleStringProperty(lastName);
    }

    public StringProperty lastNameProperty() {
        return lastName;
    }

    @Column(name = "age")
    public int getAge() {
        return age.get();
    }

    public void setAge(int age) {
        this.age = new SimpleIntegerProperty(age);
    }

    public IntegerProperty ageProperty() {
        return age;
    }

    @Column(name = "address")
    public String getAddress() {
        return address.get();
    }

    public void setAddress(String address) {
        this.address = new SimpleStringProperty(address);
    }

    public StringProperty addressProperty() {
        return address;
    }
}