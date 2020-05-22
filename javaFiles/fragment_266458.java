public class Person implements Comparable<Person>{
...
    int compareTo(Person o){
         return (fName + lname).compareTo(o.getfName() + o.getLname());
    }
...
}