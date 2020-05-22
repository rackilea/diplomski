@Entity
public class POJOWithComposites extends Model {

   @ManyToMany
   CompositeType compositePtr;

   @ManyToMany
   CompositeOtherType compositeOtherPtr;

   ...
}