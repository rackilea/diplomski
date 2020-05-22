@Table(name="profiles")
public class Profile {

(.....)

@Column(name="id", nullable=false, length=10)   
@Id 
@GeneratedValue(generator="PROFILE_ID_GENERATOR")   
@org.hibernate.annotations.GenericGenerator(name="PROFILE_ID_GENERATOR", strategy="native") 
private Integer id;

@Column(name="status", nullable=true, length=20)    
private String status;

@PrimaryKeyJoinColumn   
@OneToOne(optional=false, targetEntity=User.class, fetch=FetchType.LAZY)    
@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK}) 
@JoinColumns({ @JoinColumn(name="userid", referencedColumnName="id", nullable=false) }) 
private User user;

@Column(name="userid", nullable=false, insertable=false, updatable=false)   
@Id 
@GeneratedValue(generator="PROFILE_USERID_GENERATOR")   
@org.hibernate.annotations.GenericGenerator(name="PROFILE_USERID_GENERATOR", strategy="foreign", parameters=@org.hibernate.annotations.Parameter(name="property", value="user"))    
private int userId;

(....)
}


public class User {
(.....)

@Column(name="id", nullable=false, length=10)   
@Id 
@GeneratedValue(generator="USER_ID_GENERATOR")  
@org.hibernate.annotations.GenericGenerator(name="USER_ID_GENERATOR", strategy="native")    
private int id;

@Column(name="nickname", nullable=true, length=25)  
private String nickname;

@Column(name="password", nullable=true, length=25)  
private String password;

@OneToOne(mappedBy="user", targetEntity=Profile.class, fetch=FetchType.LAZY)    
@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK}) 
private Profile profile;

}