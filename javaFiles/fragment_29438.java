@Entity
@Table(name = "DOG")
@NamedQueries({
   @NamedQuery(name="Dog.findOldestKennel", query="SELECT d.kennel 
       FROM Dog d order by d.created ASC LIMIT 1"),
   @NamedQuery(name="Dog.getAllKennelsInAgeOrder", query="SELECT d.kennel 
       FROM Dog d order by d.created ASC")
})
public class Dog {
    @Id
    private String id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "BORN")
    private DateTime created;

    @Column(name= "KENNEL_ID)
    private String kennelId;        

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "KENNEL_ID")
    private Kennel kennel;

}