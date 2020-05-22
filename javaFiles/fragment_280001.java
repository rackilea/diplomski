private double trainingStats(EvalParameters evalParams) {
    // ...
    double trainingAccuracy = (double) numCorrect / numEvents;
    display("Stats: (" + numCorrect + "/" + numEvents + ") " + trainingAccuracy + "\n");
    return trainingAccuracy;
}