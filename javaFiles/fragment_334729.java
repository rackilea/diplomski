@Entity
@Validated
public class Osoba {

   // your code

   @JsonView(OnlyName.class)
   private String imie;

}