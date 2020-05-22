public class SurveyFlow {

    private SurveyState state; // this represents the current step

    public SurveyFlow(boolean skipFirst) {
        this.state = skipFirst ? new SurveyASkipped() : new SurveyACompleted();
    }

    void setState(SurveyState state) {
        this.state = state;
    }

    public void takeStep(boolean skipNext) { // takeStep operation delegated 
                                             // to the state (current step)
        this.state.takeStep(skipNext, this); // "this" passed to the step so 
                                             // that it can switch to the 
                                             // next step if needed
    }
}