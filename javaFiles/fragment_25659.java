@Entity
public class Person implements Serializable {  
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Long id;

   private String name;

   @ManyToMany(mappedBy="persons")
   private List<Group> groups;

}


@Entity
public class Group implements Serializable {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Long id;

   @Basic(optional = false)
   @Column(unique = true)
   private String name;

  @ManyToMany()
  @JoinTable(name="group_map",
        joinColumns=@JoinColumn(name="GROUP_ID",referencedColumnName="ID"),
        inverseJoinColumns=@JoinColumn(name="PERSON_ID", referencedColumnName="ID"))
  private List<Person> persons;
}