@Entity
@Table(name ="HIERARCHY")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) @DiscriminatorColumn(
    name = "HIERARCHY_TYPE", discriminatorType = DiscriminatorType.STRING)      
public abstract class  Hierarchy implements Serializable {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name = "hierarchy_id", updatable = false, nullable = false)
private int hId;



@Entity
@DiscriminatorValue("F")
public class Folder extends Hierarchy  {

@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
@JoinTable(name = "FOLDER_JOIN_FILELOCATION", joinColumns = { 
        @JoinColumn(name = "folder_id") }, inverseJoinColumns = { 
        @JoinColumn(name = "file_information_id") })
private List<Hierarchy> children = new ArrayList<Hierarchy>() ;
@Column(name = "folder_name")
private String folderName;
//@Column(name = "tree_item")
//private TreeItem item;
@ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
   @JoinTable(name="FOLDER_JOIN_FOLDER",
        joinColumns = @JoinColumn(name="parent_folder_id"),
        inverseJoinColumns = @JoinColumn(name="folder_ID")
    ) 
private Hierarchy parent;




@Entity
@DiscriminatorValue("FI")
public class FileInformation extends Hierarchy  {


@Column (name = "location")
private String location;
//@Column(name = "tree_item")
//private TreeItem item;
@ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
   @JoinTable(name="FILEINFORMATION_JOIN_FOLDER",
        joinColumns = @JoinColumn(name="filelocation_id"),
        inverseJoinColumns = @JoinColumn(name="folder_ID")
    )  
private Hierarchy parent;