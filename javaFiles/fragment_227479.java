@Entity
public class Employee{
    ...

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
    /* THIS IS NOT AN INTEGER DATA TYPE, IT'S A DEPARTMENT DATA TYPE. 
    SO THE SETTER FOR THIS WILL LOOK SOMEWHAT LIKE THIS:*/

    //Setter
    public void setDepartment(Department department) {
        this.department = department
    }

    ...
    // Getters and Setters
}