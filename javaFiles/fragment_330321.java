@Entity
@Table(name = "EC_USER")
public class UserVO{
@Id
@Column(name="S_ID")
private String id;
@Column(name = "CREATED_DATE")
private Date createdDate;
@Column(name = "LAST_MODIFIED_DATE")
private Date modifiedDate;

@ManyToOne
@JoinColumn(name="created_by")
private UserVO createdBy; 


@ManyToOne
@JoinColumn(name="modified_by")
private UserVO modifiedBy; 

}