@Entity
@Table(name = "user")
public class User
{
   @Id @Column(name="user_id")
   public Long id;

   @OneToMany
   @JoinColumn(name = "user_id") // so the address table would have a user_id foreign key
   public Address address;
}