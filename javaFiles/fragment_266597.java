Employee employee = new Employee();
employee.setId(1);
employee.setFirstName("Lokesh");
employee.setLastName("Gupta");
employee.setRoles(Arrays.asList("ADMIN", "MANAGER"));

Gson gson = new Gson();

System.out.println(gson.toJson(employee));

Output:

{"id":1,"firstName":"Lokesh","lastName":"Gupta","roles":["ADMIN","MANAGER"]}