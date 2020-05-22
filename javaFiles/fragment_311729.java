public class Main {

    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        InputStream is = Main.class.getResourceAsStream("/file.json");

        List<Root> roots = mapper.readValue(is, TypeFactory.defaultInstance()
                .constructCollectionType(List.class, Root.class));
        Root root = roots.get(0);

        System.out.println("route: " + root.route);
        Map<String, String[]> arrivalTimes = root.info.stops.arrivalTime;
        for (Map.Entry<String, String[]> entry: arrivalTimes.entrySet()) {
            System.out.println(entry.getKey());
            for (String time: entry.getValue()) {
                System.out.println(time);
            }
        }
    }
}