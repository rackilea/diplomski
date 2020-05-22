Domain class

Department Table(Parent)

@Table(name = "Department")
@Entity
public class Department {
  @Id
  @GenericGenerator(name = "g1", strategy = "increment")
  @GeneratedValue(generator = "g1")
  private int deptno;
  private String deptname;
  private String depthead;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "department")
  private List<EmpDetails> empDetails = new ArrayList<EmpDetails>();

  public Department() {
    System.out.println("Department:0-param constuctor");
  }
  public int getDeptno() {
    return deptno;
  }
  public void setDeptno(int deptno) {
    this.deptno = deptno;
  }
  public String getDeptname() {
    return deptname;
  }
  public void setDeptname(String deptname) {
    this.deptname = deptname;
  }
  public String getDepthead() {
    return depthead;
  }
  public void setDepthead(String depthead) {
    this.depthead = depthead;
  }


public List<EmpDetails> getEmpDetails() {
    return empDetails;
}


public void setEmpDetails(List<EmpDetails> empDetails) {
    this.empDetails = empDetails;
}

@Transient
public void addRoomAndBed(EmpDetails empDetails) {
    if (getEmpDetails() == null) {
        setRoomAndBeds(new ArrayList<EmpDetails>());
    }
    getEmpDetails().add(empDetails);
}

@Override
public String toString() {
return "Department [deptno=" + deptno + ", deptname=" + deptname +
  ", depthead=" + depthead + "]";
}
}



Emplyee table(child)

@Table(name = "EmpDetails")
@Entity
public class EmpDetails {
@Id
private int eno;
private String ename;
private double salary;
@ManyToOne(targetEntity = Department.class,cascade = CascadeType.ALL, fetch = FetchType.LAZY)
@JoinColumn(name = "deptno", referencedColumnName = "deptno", nullable = false)
private Department dept;
public EmpDetails() {
System.out.println("EmpDetails:0-param constructor");
}
public int getEno() {
return eno;
}
public void setEno(int eno) {
this.eno = eno;
}
public String getEname() {
return ename;
}
public void setEname(String ename) {
this.ename = ename;
}
public double getSalary() {
return salary;
}
public void setSalary(double salary) {
this.salary = salary;
}
public Department getDept() {
return dept;
}
public void setDept(Department dept) {
this.dept = dept;
}
@Override
public String toString() {
return "EmpDetails [eno=" + eno + ", ename=" + ename + ", salary=" +
  salary + "]";
}
}