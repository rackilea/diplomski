package forum11059499;

import java.util.*;
import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement
public class Company {
    private String companyName;
    private String companyType;
    private List<Employee> employees = new ArrayList<Employee>();

    // getters and setters with @XmlElement on each attribute
    // ...etc...
    @XmlElement
    @XmlJavaTypeAdapter(EmployeeAdapter.class)
    public List<Employee> getEmployees() {
        return employees;
    }
    // ...etc...
}