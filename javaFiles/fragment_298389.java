@Entity
public class Project {

@EmbeddedId private ProjectId id;
@MapsId("dept")
@ManyToOne
@JoinColumns({
@JoinColumn(name="DEPT_NUM", referencedColumnName="NUM"),
@JoinColumn(name="DEPT_CTRY", referencedColumnName="CTRY")})
private Department department;
// ...
}

@Embeddable
public class ProjectId implements Serializable {

@Column(name="P_NAME")
private String name;
@Embedded
private DeptId dept;
// ...
}