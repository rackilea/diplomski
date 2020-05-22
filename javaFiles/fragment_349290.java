class Entity {
    final long id;
    final String data;

    public long getId() {
        return id;
    }

    public String getData() {
        return data;
    }

    Entity(long id, String data) {
        this.id = id;
        this.data = data;
    }
}