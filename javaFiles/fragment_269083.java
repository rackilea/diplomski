public class Employee implements Cloneable{

:
@Override
protected Object clone() throws CloneNotSupportedException {
    Employee cloned = (Employee)super.clone();
    // get the Department object of “this” Employee and make copy of it and assign it to Employee object 
    cloned.setDepartment((Department)cloned.getDepartment().clone());
    return cloned;
}}
}