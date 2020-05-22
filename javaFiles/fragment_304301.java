boolean isEmployeeFound = false;
for(Employee employee: employees){
       if(inputNewID.equals(employee.getID())){
           isEmployeeFound = true;
           System.out.println("ID: " + employee.ID + END_OF_LINE + "Name:"+employee.name + END_OF_LINE + "Salary: " + employee.grossSalary);
       } 
   }
 if(!isEmployeeFound){System.out.println("The ID is wrong. You can't retrieve the objects information.");}