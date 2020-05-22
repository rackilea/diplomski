class SurveyBCompleted extends SurveyState {

    protected void takeStep(boolean skipNext, SurveyFlow survey) {
        // ...

        survey.setState(skipNext ? new SurveyCSkipped() : new SurveyCCompleted());
    }
}

class SurveyBSkipped extends SurveyState {

    protected void takeStep(boolean skipNext, SurveyFlow survey) {
        // ...

        survey.setState(skipNext ? new SurveyCSkipped() : new SurveyCCompleted());
    }
}