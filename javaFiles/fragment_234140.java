public class CandidateFeedbackDisplay {
    private final Candidate candidate;
    private final List<Integer> feedbackIds;

    public CandidateFeedbackDisplay(Candidate candidate, List<Integer> feedbackIds) {
        this.candidate = candidate;
        this.feedbackIds = feedbackIds;
    }

    // no setters
    // add getters or make fields public, but keep final
}