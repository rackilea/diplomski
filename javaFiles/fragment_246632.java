@Entity
 public class User {
     @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
     @JoinColumn(name="roleId")
     public Role getRole() {
         return role;
     }
     ...
 }