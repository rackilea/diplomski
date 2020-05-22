public final class X {

  private final Employee emp;

  public X (Employee e){
     this.emp = e.clone ();
  }

  public String getEmpName(){
    return emp.getName();
  }

  public int getEmpSalary(){
    return emp.getSalary();
  }

}