import javax.persistence.Entity;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

@Entity
public class MyEntity{

   @PrePersist
   @PreUpdate
   private void cleanup() {
       ...correct your data here...
   }
}