@Entity
@Table("BRANCH")
public class Branch {

@OneToOne
@JoinColumn(name = "parent_id")
private Branch parent;

@OneToOne(mappedBy = "parent")
private Branch child;