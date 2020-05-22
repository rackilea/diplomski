class Person {
   private String     name;
   private int        age; 
   private Profession profession;

   public Person(String name, int age) { 
      this.name = name;
      this.age  = age;
   }

   public setProfession(Profession p) {
      this.profession = p;
   }
}

class Profession {
   private String job;
   private int salary;

   public Profession(String job, int salary) {
      this.job = job;
      this.salary = salary;
   }
}