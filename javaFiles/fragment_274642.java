for (Map.Entry<Predicate, Function<ErrorCodeUtil>> entry: decisionTable.entrySet()){
    Predicate condition = entry.getKey();
    Function<ErrorCodeUtil> action = entry.getValue();
    if (condition.test(errorCode)) {
        action.apply(this);
    }
}