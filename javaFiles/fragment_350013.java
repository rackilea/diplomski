public enum MyOperator {

    AND,
    OR,
    EQUAL_TO {
    @Override
    public String toString() {
        return ":";
    }
},
    IN

}