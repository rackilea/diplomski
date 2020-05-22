InputStreamReader input = new InputStreamReader(connection.getInputStream());

JsonArray data = new JsonParser().parse(input).getAsJsonObject().getAsJsonArray("data");

Type listType = new TypeToken<ArrayList<CustomCollection>>(){}.getType();
ArrayList<CustomCollection> collection = new Gson().fromJson(data, listType);

input.close();