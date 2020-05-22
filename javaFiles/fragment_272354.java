public final static BaseClass fromJson(String json, Class klas) throws JsonSyntaxException {
    return (BaseClass) GSON.fromJson(json, klas);
}

public final static BaseClass[] fromJson(String json, Class klas) throws JsonSyntaxException {
    return (BaseClass[]) GSON.fromJson(json, klas);
}