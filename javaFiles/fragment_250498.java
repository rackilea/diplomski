import java.util.ArrayList;
import java.util.List;

class Person {
    private String firstName;

    //Might be more fields

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Person(String firstName) {
        super();
        this.firstName = firstName;
    }

}

public class SO1 {

    public static void main(String[] args) {

        List<Person> personList = new ArrayList<Person>();
        //Either you can directly add first name in adaptor
        for (int i = 0; i < 10; i++) {
            personList.add(new Person("Name "+i));
        }

        //If you have list than you have to iterate it and add first name
        List<String> adaptorList = new ArrayList<String>();
        personList.forEach( p -> adaptorList.add(p.getFirstName()));

        System.out.println(adaptorList);
    }

}