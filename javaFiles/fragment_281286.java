class SurveyACompleted extends SurveyState {

    protected void takeStep(boolean skipNext, SurveyFlow survey) {
        // ...

        survey.setState(skipNext ? new SurveyBSkipped() : new SurveyBCompleted());
    }
}

class SurveyASkipped extends SurveyState {

    protected void takeStep(boolean skipNext, SurveyFlow survey) {
        // ...

        survey.setState(skipNext ? new SurveyBSkipped() : new SurveyBCompleted());
    }
}