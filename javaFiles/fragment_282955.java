HashMap<String, Employee> map = new HashMap<>();
map.put("Pendo826", new Employee("Pendo826", 1, "Pendo826@gmail.com"));

Employee e = map.get("Pendo826"); // get emp instance by name
e.setEmployeeName("Pendo"); // emp name of that instance edited 
System.out.println(map.get("Pendo826").getEmployeeName()); // name is changed within map