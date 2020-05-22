public class Employee implements Cloneable{

private String employeeName;
private Department department;

:
:
@Override
protected Object clone() throws CloneNotSupportedException {
return super.clone();
}
}