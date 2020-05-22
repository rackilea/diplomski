package generated;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

public class Test {

    public static void main(String[] args) throws DatatypeConfigurationException {


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

    //DepartmentType departmentID
        //setDepartmentID
        GregorianCalendar gcal = new GregorianCalendar();
        gcal.setTime(hireDate);
        XMLGregorianCalendar xgcal = DatatypeFactory.newInstance().newXMLGregorianCalendar(gcal);
      ObjectFactory factory=new ObjectFactory();

      EmployeeType emp=factory.createEmployeeType();
      emp.setJob(jList);
      emp.setDepartment(departmentType);

      emp.setEmployeeId(empID);
      emp.setFirstName(firstName);
      emp.setLastName(lastName);
      emp.setEmail(email);
      emp.setPhoneNumber(phoneNumber);
      emp.setHireDate(xgcal);

      emp.setSalary(salary);
      emp.setCommissionPct(commPct);
      emp.setManagerId(managerID);
      JAXBElement<EmployeeType> temp=factory.createEmployee(emp);

      try {


        JAXBContext jaxbContext = JAXBContext.newInstance(EmployeeType.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

        // output pretty printed
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);


        jaxbMarshaller.marshal(temp, System.out);

          } catch (JAXBException e) {
        e.printStackTrace();
          }


    }

}