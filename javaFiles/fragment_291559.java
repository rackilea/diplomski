URL url = new URL("https://en.wikipedia.org/w/api.php?action=query&prop=extracts&format=json&exintro=&explaintext=&generator=random&grnnamespace=0");
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.connect();

        JsonElement jsonElement = new JsonParser().parse(new InputStreamReader((InputStream) request.getContent()));
        JsonElement pages = jsonElement.getAsJsonObject().get("query").getAsJsonObject().get("pages");

        Set<Entry<String, JsonElement>> entrySet = pages.getAsJsonObject().entrySet();

        JsonElement yourDesiredElement = null;

        for(Map.Entry<String,JsonElement> entry : entrySet){
            yourDesiredElement = entry.getValue();
        }

        //null check for yourDesiredElement