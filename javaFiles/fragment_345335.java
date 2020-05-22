public static void main(String[] args) 
        {
           List<EmployeeList> details = new ArrayList<EmployeeList>();  
           System.out.println("Enter 3 person details");
           for(int i=1;i<=3;i++)
           {
               System.out.println("Enter details of person"+i);
               EmployeeList emp =new EmployeeList();
               emp.getEmployeeDetails();
               details.add(emp);
           }

           System.out.println("The entered person Details are as following");
           for(EmployeeList employee : details)
           {
               System.out.println("Details of person");
               employee.displayEmployeeDetails();
           }
        }