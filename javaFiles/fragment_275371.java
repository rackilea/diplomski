public static void main(String[] args) throws Exception {
    final Gson gson = new GsonBuilder().create();
    final Collection<RootClass> items = gson.fromJson(TEST_JSON, new TypeToken<Collection<RootClass>>() {
    }.getType());
    System.out.println(items);
}