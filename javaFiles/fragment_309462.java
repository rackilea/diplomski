JSONParser parser = new JSONParser();
    Object obj = null;

    try {
        obj = parser.parse(new FileReader(directory of the folder + "/fileName.extension"));
    } catch (IOException e) {
        e.printStackTrace();
    } catch (org.json.simple.parser.ParseException e) {
        e.printStackTrace();
    }

    JSONObject jsonObject = (JSONObject) obj;