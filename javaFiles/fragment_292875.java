@Entity
public class Activity implements Serializable {
   @OneToOne(cascade={CascadeType.PERSIST})
   private Notification notification;
}

@Entity
public class Notification implements Serializable { }

@Stateless
public class MrBean implements MrBeanInterface {
   @PersistenceContext()
   private EntityManager em;

   public void persistActivity() {
      Activity act = new Activity();
      act.setNotification(new Notification());
      em.persist(act);
   }
}