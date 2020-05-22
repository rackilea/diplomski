@Id
private String emp_RN_No;

@MapsId @OneToOne
@JoinColumn(name = "emp_RN_No")
private Employee employee;