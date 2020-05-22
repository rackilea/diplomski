public class Person implements Comparable<Person> {

     private String name;
     private int number;

     public Person(String name, int number) {
         this.name = name;
         this.number = number;
     }

     public int compareTo(Person p) {
         return this.number.compareTo(p.number);
     }
}