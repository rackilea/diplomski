package generated;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.xml.bind.*;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.math.*;

public class employee {

private ObjectFactory of;
private EmployeeType myEmployee;

public employee(){
    of = new ObjectFactory();
    myEmployee = of.createEmployeeType();
}

public EmployeeType make(BigInteger empID, String firstName, String lastName, String email, String phoneNumber, 
        Date hireDate, JobListType jobID, BigInteger salary, BigDecimal commPct, 
        BigInteger managerID/*, DepartmentType departmentID*/){
    EmployeeType emp=null;
    try{
        GregorianCalendar gcal = new GregorianCalendar();
        gcal.setTime(hireDate);
        XMLGregorianCalendar xgcal = DatatypeFactory.newInstance().newXMLGregorianCalendar(gcal);


         emp = of.createEmployeeType();

        emp.setEmployeeId(empID);
        emp.setFirstName(firstName);
        emp.setLastName(lastName);
        emp.setEmail(email);
        emp.setPhoneNumber(phoneNumber);
        emp.setHireDate(xgcal);
        emp.setJob(jobID);
        emp.setSalary(salary);
        emp.setCommissionPct(commPct);
        emp.setManagerId(managerID);


        DepartmentType departmentType=new DepartmentType();
        int theDepId = 1001;
        BigInteger theDepIdb = BigInteger.valueOf(theDepId);
        departmentType.setDepartmentId(theDepIdb);
        int theLocId = 1001;
        BigInteger theLocIdb = BigInteger.valueOf(theLocId);
        departmentType.setLocationId(theLocIdb);
        int theMagId = 1001;
        BigInteger theMagIdb = BigInteger.valueOf(theDepId);
        departmentType.setManagerId(theMagIdb);
        departmentType.setDepartmentName("tsetDepmName");

        emp.setDepartment(departmentType);

    }

    catch (Exception e){
    }   

    return emp;
}

public void marshal(JAXBElement<EmployeeType> employeeType) {
    try {


        JAXBContext jaxbContext = JAXBContext.newInstance(EmployeeType.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

        // output pretty printed
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);


        jaxbMarshaller.marshal(employeeType, System.out);
    } catch( JAXBException jbe ){
        // ...
    }
}


public static void main( String args[])
{
    int employeeID = 123456;        
    BigInteger empID = BigInteger.valueOf(employeeID);


    String firstName = "Ehssan";
    String lastName = "Tehrani";
    String email = "etehrani@mysenecac.ca";

    Date hireDate = null;
    try{
        DateFormat df=new SimpleDateFormat("dd/MM/yyyy");
        hireDate=df.parse("20/02/2014");
    }

    catch (Exception e){
    }


    String phoneNumber = "647-588-3774";

    JobListType jList = new JobListType();

    int theJobId = 12345;
    BigInteger jID = BigInteger.valueOf(theJobId);
    jList.setJobId(jID);

    jList.setJobTitle("Java Developer");

    int theMinSal = 50000;
    BigInteger jMinSal = BigInteger.valueOf(theMinSal);
    jList.setMinSalary(jMinSal);

    int theMaxSal = 150000;
    BigInteger jMaxSal = BigInteger.valueOf(theMaxSal);
    jList.setMinSalary(jMaxSal);

    int theSalary = 90000;
    BigInteger salary = BigInteger.valueOf(theSalary);

    BigDecimal commPct = new BigDecimal(5.0);

    int theManagerID = 12345;
    BigInteger managerID = BigInteger.valueOf(theManagerID);

//DepartmentType departmentID
    //setDepartmentID

    employee myEmp = new employee();

    EmployeeType temp=myEmp.make(empID, firstName, lastName, email, phoneNumber, hireDate, jList, salary, commPct, managerID);

    ObjectFactory factory=new ObjectFactory();
    JAXBElement<EmployeeType> test=factory.createEmployee(temp);
    myEmp.marshal(test);
}
}