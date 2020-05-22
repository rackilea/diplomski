interface HasMyProperty {
    String getC();
}
interface HasMyObject {
    HasMyProperty getB();
}
...
HasMyObject a = new HasMyObject() {
    HasMyProperty b = new HasMyProperty() {
        private final String c = "Hi!";
        @Override
        public string getC() { return c; }
    };
    @Override
    public HasMyProperty getB() { return b; }
};
System.out.println( a.getB().getC() );