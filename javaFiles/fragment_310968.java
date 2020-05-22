class Stuff {

    private ByteBuffer data;

    public Stuff() {
    }

    public Stuff(ByteBuffer data) {
        super();
        this.data = data;
    }

    public ByteBuffer getData() {
        return data;
    }

    public void setData(ByteBuffer data) {
        this.data = data;
    }

    @JsonProperty(value = "data")
    public String convertData() {
        return new String(data.array());
    }

    @JsonProperty("data")
    public void convertData(String s) {
        data = ByteBuffer.wrap(s.getBytes());
    }

}