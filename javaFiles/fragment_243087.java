import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Person {

private int priority;
private String objName;

Person(String name,int value){
    this.objName = name;
    this.priority = value;
}

public int getPriority() {
    return priority;
}

public void setPriority(int priority) {
    this.priority = priority;
}

public String getObjName() {
    return objName;
}

public void setObjName(String objName) {
    this.objName = objName;
}   

public static void main(String[] args) {
    Person M1 = new Person("M1",Priority.valueOf("ONE").getValue());
    Person M2 = new Person("M2",Priority.valueOf("ONE").getValue());
    Person M3 = new Person("M3",Priority.valueOf("ONE").getValue());
    Person M4 = new Person("M4",Priority.valueOf("ONE").getValue());
    Person M5 = new Person("M5",Priority.valueOf("ONE").getValue());
    Person W1 = new Person("W1",Priority.valueOf("THREE").getValue());
    Person W2 = new Person("W2",Priority.valueOf("THREE").getValue());
    Person W3 = new Person("W3",Priority.valueOf("THREE").getValue());
    Person W4 = new Person("W4",Priority.valueOf("THREE").getValue());      
    Person C1 = new Person("C1",Priority.valueOf("TWO").getValue());
    Person C2 = new Person("C2",Priority.valueOf("TWO").getValue());

    Person[] arr = {M1,M3,C1,W1,W3,M2,M4,W2,C2,W4,M5};

    List<Person> list = Arrays.asList(arr);

    System.out.println("Before sort...");
    for(Person p : list){
        System.out.println(p.getObjName());
    }

    Collections.sort(list, new PersonComparator<Person>());

    System.out.println("After sort...");
    for(Person p : list){
        System.out.println(p.getObjName());
    }
}

}

enum Priority{  
ONE(1),TWO(2),THREE(3); 

private int value;  
public int getValue() {
    return value;
}   
Priority(int v){
    this.value = v;
}
}

class PersonComparator<T> implements Comparator<Person> {
public int compare(Person p1, Person p2) {
    //Sorting based on priority
    int v1 = p1.getPriority();
    int v2 = p2.getPriority();
    ;
    if (v1 - v2 == 0) {
        //Sorting based on object name
        int i1 = Integer.parseInt(p1.getObjName().substring(1, 2));
        int i2 = Integer.parseInt(p2.getObjName().substring(1, 2));
        return i1 - i2;
    }
    return v1 - v2;
}
}