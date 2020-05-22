public class JsonToJava {

    public static void main(String[] args) throws IOException {
        try(Reader reader = new InputStreamReader(JsonToJava.class.getResourceAsStream("/Server1.json"), "UTF-8")){
            Gson gson = new GsonBuilder().create();
            Person p = gson.fromJson(reader, Person.class);
            System.out.println(p);
        }
    }
}