public static void main(String... args) {

    try {
        List<String> list = new ArrayList<String>();
        String json = "..\\json.txt"; //Location of your json file
        JSONParser parser = new JSONParser();

        Object parsed = parser.parse(new FileReader(json));
        JSONObject jsonObject = (JSONObject) parsed;

        JSONObject data = (JSONObject) jsonObject.get("data");
        Iterator<?> keys = data.keySet().iterator();

        while (keys.hasNext()) {
            if (data.get(keys.next()) instanceof JSONObject) {
                JSONObject id = (JSONObject) data.get(keys.next());

                list.add((String) id.get("name"));
                System.out.println("Yo => " + (String) id.get("name"));
            }

        }

        // Used to show if the list is empty or not.
        JOptionPane.showMessageDialog(null, list);
    } catch (FileNotFoundException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (ParseException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
}