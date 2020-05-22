public enum CustomerType {
    Phone("Phone"), Store("Store"), Online("Online"), Home("Home");

    private String id;

    public CustomerType(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}