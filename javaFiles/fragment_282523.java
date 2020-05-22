doInBackground(Boolean.class, "{posts: [true, false]}");

protected MyJson<T> doInBackground(Class<T> type, String json, Void... params) {

    GsonBuilder gson = new GsonBuilder();
    Type collectionType = new TypeToken<MyJson<T>>(){}.getType();

    MyJson<T> myJson = gson.create().fromJson(json, collectionType);

    System.out.println(myJson.getPosts()); // [true, false]
    return myJson;
}