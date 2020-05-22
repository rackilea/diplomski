public class Person {
   @NotNull
   @Size(min=3, max=20)
   private String firstname;

   @NotNull
   @Size(min=3, max=20)
   private String lastname;

   // ... getters & setters ...
}