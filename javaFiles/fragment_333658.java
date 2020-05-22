private static JSONObject readUserJSON() throws FileNotFoundException, IOException, ParseException {
        String jarPath = (new File("")).getAbsolutePath();
        JSONObject config = null;
        JSONParser parser = new JSONParser();
        config = (JSONObject) parser.parse(new FileReader(jarPath + "resource/files/userJSON.json"));

        return config;

    }