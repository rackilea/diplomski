@Embedded
@AttributeOverrides({
    @AttributeOverride(name="startDate", column=@Column(name="EMP_START")),
    @AttributeOverride(name="endDate", column=@Column(name="EMP_END"))
})
public EmploymentPeriod getEmploymentPeriod() { ... }