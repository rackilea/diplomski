@Entity
@Table(name = "Parent")
public class Parent
{
   ...
   ...
   @OneToMany(mappedBy = "parent", cascade = javax.persistence.CascadeType.REMOVE)
   private List<Child> children;

}

@Entity
@Table(name = "Child")
public class Child
{
   ...
   ...
   @ManyToOne
   @JoinColumn(name="parent_id", referencedColumnName="id")
   private Parent parent;


}