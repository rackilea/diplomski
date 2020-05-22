public class BoxUser implements Serializable {
private static final long serialVersionUID = 1L;

@EmbeddedId
private BoxUserPK id;

@Enumerated(EnumType.STRING)
@Column(nullable=false)
private UserRole role;

//bi-directional many-to-one association to Box
@ManyToOne
@JoinColumn(name="boxid", nullable=false, insertable=false, updatable=false)
@Cascade({ org.hibernate.annotations.CascadeType.ALL})
private Box box;

//bi-directional many-to-one association to User
@ManyToOne
@JoinColumn(name="userid", nullable=false, insertable=false, updatable=false)
@Cascade({ org.hibernate.annotations.CascadeType.ALL})
private User user;