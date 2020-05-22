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

//getters & setters

}  

@Entity  
@Table(name="address")  
public class address{  

@Id  
@Column(name="address_id")    
private Integer addressId;  

private String street;  

//getters & setters

}