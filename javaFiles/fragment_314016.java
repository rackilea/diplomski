public static void main(String[] args) throws IOException, JSONException, ParseException {
    try {
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(new FileReader("/home/Desktop/temp.json"));
        JSONObject objJsonObject = new JSONObject(obj.toString());
        System.out.println(objJsonObject);
        JSONArray Liste = objJsonObject.getJSONArray("ListeCar");
        String listeCar = Liste.getJSONObject(0).getString("id");
        for (int i = 0; i < Liste.length(); i++) {
            String id = Liste.getJSONObject(i).getString("id");
            System.out.println(id);
            String size = Liste.getJSONObject(i).getString("size");
            System.out.println(size);
            String Orientation = Liste.getJSONObject(i).getString("Orientation");
            System.out.println(Orientation);
            String Position = Liste.getJSONObject(i).getJSONObject("Position").toString();
            System.out.println(Position);
        }
    } catch (JSONException e) {
        e.printStackTrace();
    }
}