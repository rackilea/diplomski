package study;
import javax.ejb.Stateless;

@Stateless
public class NewClass implements NewInterface{

    @Override
    public void sayHello(String name) {
       System.out.println("Hello " + name);
    }  
}