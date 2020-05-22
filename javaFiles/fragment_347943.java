public static class B {

    List<SomeObject> someObjects;

    public List<SomeObject> getSomeObjects() {
        if (someObjects == null) {
            someObjects = new ArrayList<SomeObject>();
        }
        return someObjects;
    }

    public void setSomeObjects(List<SomeObject> someObjects) {
        this.someObjects = someObjects;
    }
}