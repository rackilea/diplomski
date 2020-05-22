public class Employee{
   private String name;
   private Long dob;
   //default constructor and getter/setter
}

public class Project{
   private String reference;
   private String name;
   //default constructor and getter/setter
}

public class EmployeesToProject{
  private Project project;
  private List<Employee>;
  //default constructor and getter/setter
}

public class CompleteJSON{
   private List<Employee> employees;
   private List<Project> projects;
   private List<EmployeesToProject> projectMembers;
   //default constructor and getter/setter
}