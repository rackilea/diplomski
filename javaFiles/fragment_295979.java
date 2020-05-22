Reader jsonReader =
                new BufferedReader(
                new InputStreamReader(getIStream("myFile.json")));
JsonParser parser = new JsonParser();
JsonObject top = parser.parse(jsonReader).getAsJsonObject();

JsonElement importantEl = top.get("important");

//Parse the important element into whatever structure you're creating
Gson gson = new Gson();
List<Important> important 
    = Gson.fromJson(importantEl, new TypeToken<ArrayList<Important>>(){}.getType() );