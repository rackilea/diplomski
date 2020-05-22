public String infoToJson(Info i)
{
    GsonBuilder gson = new GsonBuilder();
    gson.registerTypeAdapter(Info.class, new InfoSerializer());
    return gson.create().toJson(i);
}