import java.util.ArrayList;
import java.util.List;

import cjm.component.cb.object.ToObject;

public class EmployeeConversion
{
public static void main(String[] args)
{
    try
    {
        String xml = "<employeeId>323</employeeId><name>Samuel DCosta</name><department><departmentId>2</departmentId><name>Accounts</name></department><salary>11290</salary>";

        List<Object> objectList = new ArrayList<Object>();

        objectList.add(new Employee());
        objectList.add(new Department());         // adding all the nested objects within the Employee bean into this list

        Employee employee = (Employee) new ToObject().convertToObject(xml, new Employee(), objectList); // this will carry out the mapping to the bean

        System.out.println(employee);
    }
    catch (Exception e)
    {
        e.printStackTrace();
    }
}
}