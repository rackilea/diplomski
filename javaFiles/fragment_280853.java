@Entity
public class Schedule extends PersistentObject implements Comparable<Schedule> {

   @Column
   private String title;

   @ManyToOne
   private Agent target;

   @OneToMany 
   private List<Unit> units = new List<>();

}

@Entity
public class Unit {

  @ManyToMany 
  private List<Role> assignedRoles = new List<>();

}