class Fruit {
    protected String callingTaste() {
        return "";
    }

    public String callingName() {
        return callingTaste();
    }
}