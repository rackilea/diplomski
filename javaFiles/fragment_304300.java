for(Employee employee: employees){
       if(inputNewID.equals(employee.getID())){
           System.out.println("ID: " + employee.ID + END_OF_LINE + "Name: " + employee.name + END_OF_LINE + "Salary: " + employee.grossSalary);
       } else {
           System.out.println("The ID is wrong. You can't retrieve the objects information.");
       }
   }