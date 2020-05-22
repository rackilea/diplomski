import java.util.ArrayList;
import java.util.List;

public class AssessmentLevel {

    private String assessment;
    private String level;
    private List<String> personalizedexercises = new ArrayList<>();

    public String getAssessment() {
        return assessment;
    }

    public void setAssessment(String assessment) {
        this.assessment = assessment;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public List<String> getPersonalizedexercises() {
        return personalizedexercises;
    }

    public void setPersonalizedexercises(List<String> personalizedexercises) {
        this.personalizedexercises = personalizedexercises;
    }

}