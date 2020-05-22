doInBackground(String.class, "{posts: [\"article 1\", \"article 2\"]}");

protected MyJson<T> doInBackground(Class<T> type, String json, Void... params) {

    GsonBuilder gson = new GsonBuilder();
    Type collectionType = new TypeToken<MyJson<T>>(){}.getType();

    MyJson<T> myJson = gson.create().fromJson(json, collectionType);

    System.out.println(myJson.getPosts()); // ["article 1", "article 2"]
    return myJson;
}