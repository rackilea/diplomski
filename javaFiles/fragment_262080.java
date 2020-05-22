import java.util.ArrayList;

public class Storage {

ArrayList<Person> objects;

public Storage(){
    objects= new ArrayList<>();
}

public void addObject(int number, int age, String name, String code) {

    objects.add(new Person(number, age, name, code));
}