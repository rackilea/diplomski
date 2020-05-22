public class Person {
String name;
int age;

public Person(String myName,int myAge) {
   name = myName;
   age = myAge;
}

public int getAge() {
    return age;
}

public String getName() {
    return name;
}

public void setAge(int newAge) {
   age = newAge;
}

public void printDetails() {
    System.out.println("The name of this person is " + getName());
}

public static void main (String[] args ) {
    Person Eliza = new Person("Eliza", 66);
    Eliza.printDetails();
}
}