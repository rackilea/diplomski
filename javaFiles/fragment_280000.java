public AbstractModel trainModel(DataIndexer di) {
    // ...
    display("done.\n");
    display("\tNumber of Event Tokens: " + numUniqueEvents + "\n");
    display("\t    Number of Outcomes: " + numOutcomes + "\n");
    display("\t  Number of Predicates: " + numPreds + "\n");
    display("Computing model parameters...\n");
    MutableContext[] finalParameters = findParameters();
    display("...done.\n");
    // ...
}