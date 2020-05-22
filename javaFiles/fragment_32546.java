import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value="singleton")
public class Person {
    private String name;

    @Autowired
    SpringTest springTest;

    public Person(){
        System.out.println("Constructor from Person");
    }

    public Person(String name){
        System.out.println("String Constructor from Person");
        this.name = name;
    }

    public void sayHello(){
        System.out.println("Hello, " + name);
    }

}