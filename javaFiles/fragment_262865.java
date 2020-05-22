public static void main(String[] args) {
    String JSON = "{\"LanguageLevels\":{\"1\":\"Pocz\\u0105tkuj\\u0105cy\",\"2\":\"\\u015arednioZaawansowany\",\"3\":\"Zaawansowany\",\"4\":\"Ekspert\"}}\n";

    JSONObject jsonObject = new JSONObject(JSON);
    JSONObject getSth = jsonObject.getJSONObject("LanguageLevels");
    Object level = getSth.get("2");

    System.out.println(level);
}