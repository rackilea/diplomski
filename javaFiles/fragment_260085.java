class BaseAlgorithm {
     run() {
        commonStepOne();
        subclassSpecificStepTwo();
     }

     protected abstract subclassSpecificStepTwo();
}