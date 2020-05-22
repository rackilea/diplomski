public class Test {
    public static void main(String[] args) {
        String json ="{\"10 m\":10,\"100 m\":100,\"1000 m\":1000}";
        LinkedHashMap<String, Double> map = new Gson().fromJson(json, new TypeToken<LinkedHashMap<String, Double>>(){}.getType());
        System.out.println(map);
    }
}