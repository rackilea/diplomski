class ProfessionalPerson extends Person {
   private String job;
   private int salary;

   public ProfessionPerson(String name, int age, String job, int salary) {
      super(name, age);
      this.job = job;
      this.salary = salary;
   } 
}