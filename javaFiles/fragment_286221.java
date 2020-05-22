@Entity
public class Schedule implements java.io.Serializable {

    private String scheduleName;
    private Set<Step> steps = new HashSet<Step>();

    @OneToMany(mappedBy="schedule", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    public Set<Step> getSteps() {
       return steps;
    }

    // other properties, getters, setters
}