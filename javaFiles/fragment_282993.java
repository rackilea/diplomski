private int mark(GradingAlgorithmInterface algorithm, DataStructure paper){
    algorithm.markPaper(paper);
}

main(){
    ...
    if(difficulty == 1){
        mark(new ConcreteEasyAlgorithm(), paper);
    } else if () {...