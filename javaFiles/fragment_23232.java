public class Worker {

    @Updatable(false)
    @Order(1)
    @ColumnName("ID")
    private int id; 

    @Updatable(true)
    @Order(2)
    @ColumnName("FIRST NAME")
    private String firstName; 

    @Updatable(true)
    @Order(3)
    @ColumnName("LAST NAME")
    private String lastName; 

    public Worker() {
    }

    public Worker(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Order(1)
    public int getId() {
        return id;
    }

    @Order(1)
    public void setId(int id) {
        this.id = id;
    }

    @Order(2)
    public String getFirstName() {
        return firstName;
    }

    @Order(2)
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Order(3)
    public String getLastName() {
        return lastName;
    }

    @Order(3)
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}