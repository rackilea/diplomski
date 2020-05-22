public enum ConnectionContext {

    INSTANCE;

    private Connector connector;

    public void setConnectionMode(Connector connector){
             this.connector=connector;
    }

    //Method Delegation 
    public Double someMethod() {
        return this.connector.someMethod();
    }
}