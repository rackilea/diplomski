private class Data {
    int id;
    String title, topic, type;
    List<String> names;

    public Data(int id, String title, String topic, String type) {
        this.id = id;
        this.title = title;
        this.topic = topic;
        this.type = type;
        names = new ArrayList<String>();
    }
}