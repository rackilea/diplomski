@Entity
public class Company implements Serializable {

    // ...

    @Transient
    private double averageSalary;

    public void setAverageSalary(double averageSalary) {
        this.averageSalary = averageSalary;
    }

    public double getAverageSalary() {
        return averageSalary;
    }
}