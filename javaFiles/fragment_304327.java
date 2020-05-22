public static void main(String[] args) {

        JSONParser parser = new JSONParser();

        try {
            Object obj = parser.parse(new FileReader("src/bikes.json"));

            JSONObject jsonObject = (JSONObject) obj;
            // System.out.println(jsonObject);

            JSONObject search = (JSONObject) jsonObject.get("Search");
            JSONArray bikeList = (JSONArray) search.get("BikeList");

            for (int i = 0; i < bikeList.size(); i++) {
                JSONObject bike = (JSONObject) bikeList.get(i);
                System.out.println("********************");
                System.out.println("Weight: " + bike.get("weight"));
                System.out.println("Colour: " + bike.get("colour"));
                System.out.println("Price: " + bike.get("price"));
                System.out.println("Name: " + bike.get("name"));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } 
    }