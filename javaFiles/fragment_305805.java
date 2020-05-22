@Entity
public class TrainingplanExercise implements Serializable {
    @EmbeddedId private TrainingplanExerciseId trainingplanExerciseId;

    public TrainingplanExercise() {}        
    public TrainingplanExercise(TrainingplanExerciseId trainingplanExerciseId) {
        this.trainingplanExerciseId = trainingplanExerciseId;
    }
    ... other fields ...   
}