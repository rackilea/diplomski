interface Operation{
    void execute();
}

class OperationBuilder {
    public static Operation build(TypeA A, TypeB B){
        if(A != null && B != null) { return new OperationOne(); }
        if(A == null && B == null) { return new OperationTwo(); }
        if(A != null && B == null) { /* operation3 */ }
        if(A == null && B != null) { /* operation4 */ }
    }

    class OperationOne implements Operation{
        private OperationOne(){...}
        @Override
        void execute(){...}
    }
    class OperationTwo implements Operation{
        private OperationTwo(){}
        @Override
        void execute(){...}
    }
}