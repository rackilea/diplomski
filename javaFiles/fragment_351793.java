enum Existing {
    A("attr1", "attr2"),

    Z("attr");

    private final Parent existing;

    Existing(String attr1) {
        this.existing = new ParentImpl(attr1);
    }

    Existing(String attr1, String attr2) {
        this.existing = new ParentImpl(attr1, attr2);
    }

    public Parent getParent() {
        return existing;
    }

    // only needed if logic is overridden
    private static class ParentImpl extends Parent {
        public static final Existing A = "";
        public static final Existing Z = "";

        public ParentImpl(String attr1, String attr2) {
            super(attr1, attr2);
        }

        public ParentImpl(String attr1) {
            super(attr1);
        }
    }
}