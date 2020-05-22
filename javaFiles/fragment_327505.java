Employee emp1 = new Employee("John Doe"):
 emp2 = emp1;

 emp1 = new Employee("John");  
 // In this case emp2 hold a strong reference to previously created Object
 // so its not eleigible for Garbage collection