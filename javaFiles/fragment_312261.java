@Entity
@Table(name = "Projects")
public class Project implements java.io.Serializable{

    private static final long serialVersionUID = 5115375190980452672L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Project_Id")
    private int id; // this should be set once on creation and never touched
                    // again as it identifies the project uniquely
    @Column(name = "Owner_Id")
    private int ownerId;
    @Column(name = "Name")
    private String name;
//  @ElementCollection
//  @CollectionTable(name="Activities", joinColumns=@JoinColumn(name="Project_Id"))
//  @Column(name="Activity")
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name="Project_Id")
    private List<Activity> activities;

    public Project(){

    }
    /**
     * Constructor to load existing project
     * @param idToLoad id of the project to load
     */
    public Project(int idToLoad) { 
//      MySqlDriver.loadObjectWithId(this, idToLoad);
        org.hibernate.Session session;
        try{
            session=Start.getFactory().getCurrentSession();
        }catch(Exception e){
            System.out.println("Could not load project.");
            System.out.println("Error while creating mysql session: "+e);
            return;
        }
        try{
            session.beginTransaction();
            session.load(this, idToLoad);
            this.activities.size();
            session.getTransaction().commit();
        }catch(Exception e){
            System.out.println("Could not load project.");
            System.out.println("Error while committing changes: "+e);
            session.getTransaction().commit();
        }
    }

    /**
     * Creates new project
     * @param newName name of the new project
     * @param newId id of the new project
     */
    public Project(String newName, int owner_Id) { // on creation a project
                                                        // only has a name and a
                                                        // unique id
        this.name = newName;
        this.ownerId = owner_Id;
        this.activities = null;
    }

    public void addActivity(String activityName) { // add new activity to the
                                                    // project with given
                                                    // attributes
        Activity newActivity = new Activity(activityName, this.id);
        this.activities.add(newActivity);
    }

    public void setName(String newName) { // change project name
        this.name = newName;
    }

    public String getName() { // return project name
        return this.name;
    }

    public List<Activity> getActivities(){
        return this.activities;
    }

    public int getId(){
        return this.id;
    }

    public void commitChanges() {
        for (Activity act : this.activities)
            act.commitChanges(); // commit changes made to all activities in the
                                    // project
        MySqlDriver.saveObject(this);
    }

    public void deleteProject() {
        MySqlDriver.deleteObject(this);
    }

    public Activity selectActivity(String activityName) {
        for (Activity act : activities) { // cycle through activities and return
                                            // the one with the given name
            if (act.getName().equals(activityName))
                return act;
        }
        return null;
    }

    public void deleteActivity(String deleteMeName) {
        for (Activity act : activities) { // cycle through activities and delete
                                            // the one with the given name
            if (act.getName().equals(deleteMeName)) {
                MySqlDriver.deleteObject(act);
                activities.remove(act);
                break;
            }
        }
    }

    public void grantAccessToProject(String otherUser) {
        // grants permission to view and modify project database to user
        // otherUser
    }
}