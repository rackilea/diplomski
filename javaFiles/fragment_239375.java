public enum MyForm implements MetaData {

    USER_NAME(1301726507L),
    MESSAGE(1466759457L);

    private long id;

    JGForm(long id) {
        this.id = id;
    }

    @Override
    public long getId() {
        return this.id;
    }
}