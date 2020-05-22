private <T extends Collection<U>, U> T collectionFromJson(String pResponseJson, TypeToken<T> typeToken) {
    return (T)new Gson().fromJson(pResponseJson, typeToken.getType());
}

...

TypeToken<List<GameInfo>> typeToken = new TypeToken<List<GameInfo>>() { };
List<GameInfo> lst = collectionFromJson(response, typeToken);