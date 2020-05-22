ExpensiveObject o;

public ExpensiveObject getExpensiveObject() {
    if (o == null) {
        o = new ExpensiveObject();
    }
    return o;
}