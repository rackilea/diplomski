package whatever;

import predictor.version1.Predictor;

public class Result {
    // Uses the Predictor from package predictor.version1 which was imported
    public void prediction(Predictor p) {
        // ...
    }

    // Use fully-qualified class name to indicate that Predictor
    // from package predictor.version2 should be used
    public void prediction(predictor.version2.Predictor p) {
        // ...
    }
}