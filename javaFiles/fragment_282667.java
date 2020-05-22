@Entity
public class School 
{
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID; 

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy="school")
    private List<Teacher> teachers;

    @OneToMany(cascade = CascadeType.PERSIST,mappedBy="school")
    private List<Workshop> workshops;
// Getters and Setters and some methods
    }