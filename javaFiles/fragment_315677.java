@Entity  
@Table(name="person")  
public class person{  

@Id  
@Column(name="person_id") 
@GeneratedValue     
private Integer personId;  

private String name;  

@OneToOne(cascade=CascadeType.ALL)  
@PrimaryKeyJoinColumn 
private address address;

@OneToMany(cascade=CascadeType.ALL)
@JoinColumn(name = "person_id")
private List<car> cars;


//getters & setters

}