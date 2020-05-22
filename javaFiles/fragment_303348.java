public class RMSRecommenderEvaluatorModified extends AbstractKFoldRecommenderEvaluator {

private RunningAverage average;


@Override
protected void reset() {
    average = new FullRunningAverage();
}

@Override
protected void processOneEstimate(float estimatedPreference, Preference realPref) {
    double diff = realPref.getValue() - estimatedPreference;
    average.addDatum(diff * diff);
}

@Override
protected double computeFinalEvaluation() {
    return Math.sqrt(average.getAverage());
}

@Override
public String toString() {
    return "RMSRecommenderEvaluator";
}}