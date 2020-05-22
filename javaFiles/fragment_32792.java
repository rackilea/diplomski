interface Fooable {
     Fooable createInstance();
     void doFoo();
     void doBar();
}

class Car implements Fooable {
     public Fooable createInstance() {
          return new Car();
     }
     public void doFoo(){
         out.println("Brroooom, brooooom");
     }
     public void doBar() {
          out.println("Schreeeeeeeekkkkkt");
      }
}
class Person implements Fooable {
     public Fooable createInstance(){   
         return new Person();
      }
      public void foo() {
           out.println("ehem, good morning sir");
      }
      public void bar() {
          out.println("Among the nations as among the individuals, the respect for the other rights means peace..");// sort of 
      }
}