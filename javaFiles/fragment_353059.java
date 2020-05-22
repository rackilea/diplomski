@Entity(name="SokoTable")

// the next line is optional if you annotate the get methods (as done below):
@Access("AccessType.PROPERTY")

public class Score implements Serializable{

    private final IntegerProperty id = new SimpleIntegerProperty() ; 

    private final StringProperty userName = new SimpleStringProperty() ;
    private final StringProperty levelName = new SimpleStringProperty() ;
    private final IntegerProperty steps = new SimpleIntegerProperty() ;
    private final IntegerProperty time = new SimpleIntegerProperty() ;

    public Score(){ 
    }
    public Score(String userName, String levelName, int steps, int time) {
        super();
        setUserName(userName);
        setLevelName(levelName);
        setSteps(steps);
        setTime(time);
    }

    @Column(name="ID")
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public int getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id.set(id);
    }

    @Column(name="Username")
    public String getUserName() {
        return userName.get();
    }
    public void setUserName(String userName) {
        this.userName.set(userName);
    }
    @Column(name="Level")
    public String getLevelName() {
        return levelName.get();
    }
    public void setLevelName(String levelName) {
        this.levelName.set(levelName);
    }
    @Column(name="Steps")
    public int getSteps() {
        return steps.get();
    }
    public void setSteps(int steps) {
        this.steps.set(steps);
    }
    @Column(name="Time")
    public int getTime() {
        return time.get();
    }
    public void setTime(int time) {
        this.time.set(time);
    }   
}