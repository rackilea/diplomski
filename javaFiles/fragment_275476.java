import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Person {

   @Column(length=30)
   private String firstName;

   public static void main(String[] args) throws SecurityException, NoSuchFieldException {
      Object person = new Person();
      //find out length    
      System.out.println(person.getClass().getDeclaredField("firstName").getAnnotation(Column.class).length());
   }
}