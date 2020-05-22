@Entity
public class Document {
@Id
@Column(name="DOCUMENT_ID")
private int id;

@ManyToOne
@JoinColumn(name="DOCUMENT_REVISION_ID")
private DocumentRevisionEntity revision;  // This is the last revision!

@OneToMany
@JoinColumn(name="DOCUMENT_ID") // unidirectional one-to-many, works for JPA2.0!!
private List<DocumentRevisionEntity> revisions = new ArrayList<>();
}