@Entity
public class TrainingPlan implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @ManyToMany(fetch=FetchType.EAGER)
    private List<TrainingplanExercise> trainingplanExercises = new ArrayList<TrainingplanExercise>();

    ... getters, setters, 
}