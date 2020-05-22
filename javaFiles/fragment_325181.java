public static void main(String[] args){
    String json = "{\"myContainer\":{\"couldBeAnything\":[{\"id\":1,\"name\":\"sb\",\"category\":\"couldBeAnything\"},{\"id\":2,\"name\":\"bs\",\"category\":\"couldBeAnything\"}],\"somethingElse\":[{\"id\":1,\"name\":\"sdsa\",\"category\":\"somethingElse\"},{\"id\":2,\"name\":\"ve\",\"category\":\"somethingElse\"}]},\"id\":0}";

    Map<String, List<Foo>> obj = new HashMap<String, List<Foo>>();
    Gson gson = new Gson();
    obj = gson.fromJson(json, obj.getClass());
    System.out.println(obj);
}