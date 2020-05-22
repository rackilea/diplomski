@Entity
public class ViewedProductsPerCategory {
   @Id
   @GeneratedValue
   long id;

   @OneToMany 
   Category category;

   long CatCounter;

   long ProCounter;

   getters and setters;
}