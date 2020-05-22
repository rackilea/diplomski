public class EmpLoc  implements Comparable<EmpLoc>  {
String employee;
String location;

public EmpLoc (String _employee, String _location)
    {
    employee=_employee;
    location=_location; 
    }


@Override
public int compareTo(EmpLoc other)
    {
    int last = this.location.compareTo(other.location);
    return last == 0 ? this.employee.compareTo(other.employee) : last;
    }

}