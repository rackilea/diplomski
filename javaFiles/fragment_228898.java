for(int i = 0; i < list.size(); i++) {
 System.out.println("Element class: " + list.get(i).getClass());
 if (list.get(i) instanceof EmployeeBean) {
  EmployeeBean e = (EmployeeBean) list.get(i);
  // keep with operations
 }
}