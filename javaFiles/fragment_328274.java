@IdClass(EmpSkillKey.class)
@Entity
class EmployeeSkillSet {
    @Id 
    @Column("employee_id")
    private Long employeeId;
    @Id
    @Column("skill_id")
    private @Id Long skillId;

    @JoinColumn(name="employee_id", insertable=false, updatable=false)
    @ManyToOne  
    private Employee employee;
    private int numberOfYears;
}