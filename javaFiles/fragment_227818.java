public class Jackson {
    public static void main(String[] args) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            String jsonAsString = "{\"age\":10}";
            Child child = mapper.readValue(jsonAsString, Child.class);
            System.out.println(child);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}