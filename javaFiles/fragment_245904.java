List<Person> personsParameter = new ArrayList<>();
Person person = new Person();
person.setName("Pippo");
personsParameter.add(person);
Employees employees = new Employees(personsParameter);

// Prints Pippo    
System.out.println(employees.getPersons().get(0).getName()); 


employees.getPersons().get(0).setName("newName");

// Prints again Pippo    
System.out.println(employees.getPersons().get(0).getName()); 

// But modifiyng something reachable from the parameter 
// used in the constructor 
person.setName("Pluto");

// Now it prints Pluto, so employees has changed    
System.out.println(employees.getPersons().get(0).getName());