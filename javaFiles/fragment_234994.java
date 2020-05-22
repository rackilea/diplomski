public class App {

    public static void main(final String[] args) throws FileNotFoundException, IOException, ParseException {
        final Object obj = new JSONParser().parse(new FileReader("D:/a.json"));
        final JSONObject jsonObject = (JSONObject) obj;
        final JSONObject user = (JSONObject) jsonObject.get("user");
        final JSONArray list = (JSONArray) user.get("SomeList");
        System.out.println(list);
    }
}