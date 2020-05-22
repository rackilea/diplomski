@Entity
public class Employee  {

    @ManyToMany(mappedBy="employee")
    private List<Meeting> meetings;
    ...
}