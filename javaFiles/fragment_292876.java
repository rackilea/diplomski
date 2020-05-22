@Entity
public class Activity implements Serializable {
   @OneToOne(cascade={CascadeType.PERSIST})
   private Notification notification;

   public Activity() {
      this.notification = new Notification();
   }
}

@Entity
public class Notification implements Serializable { }

@Stateless
public class MrBean implements MrBeanInterface {
   @PersistenceContext()
   private EntityManager em;

   public void persistActivity() {
      Activity act = new Activity();
      em.persist(act);
   }
}