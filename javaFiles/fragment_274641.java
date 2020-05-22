Predicate equalsOne = new Predicate() { 
    public void test(String x) {
         return "1".equals(x);
    }
};
Function<ErrorCodeUtil> actionOne = new Function<ErrorCodeUtil>() {
    public void apply(ErrorCodeUtil t) {
        t.handleErrorCode1();
    }
}

decisionTable.put(equalsOne, actionOne);