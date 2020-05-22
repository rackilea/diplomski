public static void main(String[] args) throws Exception {
    String json = "{\"value\" : 01}";
    Gson gson = new GsonBuilder().create();
    System.out.println(gson.getAdapter(Value.class).fromJson(json));
}

static class Value {
    Integer value;

    public String toString() {
        return "" + value;
    }
}