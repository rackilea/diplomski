@Embeddable
public class EmployeeIdClass implements Serializable{

    @Column(name = "REGISTER_NUMBER", nullable = false, length = 100)
    private String registerNumber;

    @Column(name = "NAME", nullable = false, length = 50)
    private String name;

    public String getRegisterNumber() {
        return registerNumber;
    }

    public void setRegisterNumber(String registerNumber) {
        this.registerNumber = registerNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeIdClass that = (EmployeeIdClass) o;
        return Objects.equals(registerNumber, that.registerNumber) &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(registerNumber, name);
    }
}