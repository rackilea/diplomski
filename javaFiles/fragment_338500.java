private static <T> Map<String, T> readRequestFromJson(File jsonFile, TypeToken<Map<String, T>> typeToken) {
        Map<String, T> requestBodyMap = null;
        try {

            FileReader fileReader = new FileReader(jsonFile);
            JsonReader jsonReader = new JsonReader(fileReader);
            Gson gson = new Gson();

            requestBodyMap = gson.fromJson(jsonReader,  typeToken.getType());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return requestBodyMap;
}  
public static void main(String[] args) throws Exception {

        Map<String, Person> myMap = (Map<String, Person>) readRequestFromJson(new File("C:/Users/User.Admin/Desktop/jsonFile"),
                new TypeToken<Map<String, Person>>() {
                });   

        for (Map.Entry<String, Person> entry : myMap.entrySet()) {
            System.out.println(entry.getValue().getFirstName());
        }
    }