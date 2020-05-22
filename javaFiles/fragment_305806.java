@Embeddable
public class TrainingplanExerciseId implements Serializable {
    private String exercise;
    private String parameter;

    public TrainingplanExerciseId() {}
    public TrainingplanExerciseId(String exercise, String parameter) {
        this.exercise = exercise;
        this.parameter = parameter;
    }

    ... getters, setters, hashCode, and equals
}