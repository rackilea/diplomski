class User {

    @JsonAdapter(OneOrElementJsonDeserializer.class)
    private Data data;

    public User() {
    }

    public User(Data data) {
        super();
        this.data = data;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "User{" +
                "data=" + data +
                '}';
    }
}

class Data {

    private String id;

    protected String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Data{" +
                "id='" + id + '\'' +
                '}';
    }
}