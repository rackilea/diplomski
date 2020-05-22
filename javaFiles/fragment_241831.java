class ObjectBuilder {
    private SomeObject someObject = new SomeObject();

    public ObjectBuilder withPropertyX(int x) {
        someObject.setPropertyX(x);
        return this;
    }

    public ObjectBuilder withPropertyY(String y) {
        someObject.setPropertyY(y);
        return this;
    }

    public SomeObject build() {
        return someObject;
    }

}

ObjectBuilder builder = new ObjectBuilder();

SomeObject someObject = builder.withPropertyX(5).withPropertyY("test").build();