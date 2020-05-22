@Entity
@ApiModel(description = "A cast member that has been part of making the movie")
public class Cast implements Serializable {
    private static final long serialVersionUID = 6771189878622265738L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    //Remove extendedmovie from here
    //other property getter and setters here
}