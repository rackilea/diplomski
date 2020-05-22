System.out.println("Edit");
Employee employeeEdit = MenuMethods.userInputByName();
Employee e = Store.searchByName(employeeEdit.getEmployeeName());
if (e != null) 
{
  e.setEmployeeName("Joe");
  e.setEmployeeId(1);
  e.setEmployeeEmail("webmail.com");
  // Store.edit(employeeEdit); // no need as you already have made changes to reference e
}
break;