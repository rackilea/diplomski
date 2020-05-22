public static void main(String[] args) throws IOException {
        String collect = Files.lines(Paths.get("src/main/resources/waether.json")).collect(Collectors.joining());

        JSONObject jsonObject = new JSONObject(collect);
        JSONArray array = jsonObject.getJSONArray("list");
        JSONObject firstObject = (JSONObject)array.get(0);
        double tempmax = firstObject.getJSONObject("main").getDouble("temp_max");
        double tempmin = firstObject.getJSONObject("main").getDouble("temp_min");

        System.out.println("Temp min " + tempmin);
        System.out.println("Temp max " + tempmax);
    }