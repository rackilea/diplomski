public class Parent {
   @JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
   @JsonIdentityReference(alwaysAsId=true) // otherwise first ref as POJO, others as id
   public Child child; // or use for getter or setter

   // if using 'PropertyGenerator', need to have id as property -- not the only choice
   public int id;
}