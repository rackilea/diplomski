@Entity
public class Address {
   @Id
   public Long id;

   @OneToOne(mappedBy = "addressHome")
   public Relation relationHome;

   @OneToOne(mappedBy = "addressWork")
   public Relation relationWork;
}