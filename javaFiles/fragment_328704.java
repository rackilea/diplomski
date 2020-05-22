public class ClassA {

     private String name;
     private int age;

     public ClassA(String name, int age)
          this.name = name;
          this.age = age;
     }

     public String getName() {
          return name;
     }

     public int ageGetAge() {
          return age;
     }
}

public class ClassB extends ClassA {

     private String tenant;

     public ClassB(String name, int age, String tenant) {
          super(name, age);
          this.tenant = tenant;
     }

     public String getTenant() {
          return tenant;
     }
}