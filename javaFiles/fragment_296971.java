@Entity
@Table(name="sal_emp")
public class SalEmp {

    @Id
    private String name;

    @Column(name="pay_by_quarter")
    @Type(type = "packageofclass.GenericArrayUserType")
    private Integer[] payByQuarter;

    @Column(name="schedule")
    @Type(type = "packageofclass.GenericArrayUserType")
    private String[][] schedule;

    //Getters, Setters, ToString, equals, and so on

}