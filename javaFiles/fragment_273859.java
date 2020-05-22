public enum SoultionType {
    A(ProblemType.A, ProblemType.C), 
    B(ProblemType.A);

    //...

    SoultionType(ProblemType problems...) {
        // ...
    }

    public static SoultionType getByProblemType(ProblemType problem) {
        // ...
    }
}