Map<String, Object> theTable = new HashMap<>();
theTable.put("employeeId12345", new Employee());
System.out.println("Enter your username: ");
Scanner sc = new Scanner(System.in);
String userSearch = sc.nextLine(); // assume it will return employeeId12345

if (theTable.contains(userSearch )){
  return theTable.get(userSearch);
}