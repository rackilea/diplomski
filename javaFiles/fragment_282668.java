@Entity
public class Teacher 
{

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Key key;

     @ManyToOne(fetch=FetchType.LAZY)
     @JoinColumn(name="key")
    private School school;

    // Getters and Setters and some methods}