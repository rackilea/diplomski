public class UI{ // <---- this class will control the flow of your program
    public static void main(String[] args){
        private List<Company> company; // <---- this Collection object holds many Company objects
        ...
        for(int i=0;i<company.size();i++){
            Company c = new Company();
            c.setName(br.readLine());
            List<Employee> employee = new ArrayList<Employee>();
            ...
            for(int j=0;j<employee.size();j++){
                Employee e = new Employee();
                e.setName(br.readLine());
                ...
                employee.add(e);
            }
            c.setEmployee(employee);
            company.add(c);
         }
    }
}

public class Company{ // <---- this class will represent the companies
    private List<Employee> employee;
    private String name;
    public void setEmployee(List<Employee> employee){
        this.employee = employee;
    }
    ....
}

public class Employee{ // <----- this class will represent the employees
    private String name;
    private int empNo;
    public int getEmpNo(){
        return empNo;
    }
    ...
}