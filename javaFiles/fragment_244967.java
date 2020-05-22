@Entity
@IdClass(MyKey.class)
public class YourEntity {
   @Id
   private int id;
   @Id
   private int version;

}