@Entity
@Table(name="takeCourse")
public class TakeCourse implements Serializable {


    @EmbeddedId 
    private CompositeKey id;

    @MapsId    
    @ManyToOne
    @JoinColumn(name = "sid")
    private Student student;

    @MapsId        
    @ManyToOne
    @JoinColumn(name = "cid")
    private Course course;

    // getters and setters
}