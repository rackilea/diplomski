final Gson gson = new GsonBuilder()
        .registerTypeAdapterFactory(getStaticTypeAdapterFactory())
        .create();
final String json = gson.toJson(DyescapeCOREConfiguration.class);
out.println("DyescapeCOREConfiguration.ServerID=" + DyescapeCOREConfiguration.ServerID);
// ---
DyescapeCOREConfiguration.ServerID = "whatever";
out.println("DyescapeCOREConfiguration.ServerID=" + DyescapeCOREConfiguration.ServerID);
// ---
@SuppressWarnings("unchecked")
final Class<DyescapeCOREConfiguration> configurationClass = gson.fromJson(json, Class.class);
//    ^--- this is awful, omitting a useless assignment is even worse
out.println("DyescapeCOREConfiguration.ServerID=" + DyescapeCOREConfiguration.ServerID);