enum ExistingEnum {
    A("attr1", "attr2"), 
    Z("attr");

    private final Existing existing;

    ExistingEnum(String attr1) {
        this.existing = new Existing(attr1);
    }

    ExistingEnum(String attr1, String attr2) {
        this.existing = new Existing(attr1, attr2);
    }

    public Existing getExisting() {
        return existing;
    }
}