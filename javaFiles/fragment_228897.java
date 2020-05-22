for(Object element : list) {
 System.out.println("Class of the element: " + element.getClass());
 // If you want to do some validation, you can use the instanceof modifier
 if(element instanceof EmployeeBean) {
  System.out.println("This is a employee");
  // Then I cast the element and proceed with operations
  Employee e = (Employee) element;
  double totalSalary = e.getSalary() + e.getBonification();
 }
}