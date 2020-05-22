JSONParser parser = new JSONParser();
try {
    Object obj = parser.parse(datJ);
    JSONObject jsonObject = (JSONObject) obj;
    JSONObject rikeardObject = (JSONObject) obj.get("rikeard");
    String name = (String) rikeardObject.get("name");
    Integer id = (Integer) rikeardObject.get("id");
    result.append(name + id);

} catch (MalformedURLException e1) {
    // TODO Auto-generated catch block
    e1.printStackTrace();
} catch (IOException e1) {
    // TODO Auto-generated catch block
    e1.printStackTrace();
} catch (org.json.simple.parser.ParseException e1) {
    // TODO Auto-generated catch block
    e1.printStackTrace();
}