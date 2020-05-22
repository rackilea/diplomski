private static ObjectMapper mapper = new ObjectMapper();

public static void main(String[] args) throws IOException {
    System.out.println(filterJsonArray(JSON, "loginName", "test0001@test.com", "status", "167"));
}

public static String filterJsonArray(String array, String keyOne, Object valueOne, String keyTwo, Object valueTwo) throws IOException {
    Map[] nodes = mapper.readValue(array, HashMap[].class);

    for (Map node : nodes) {
        if (node.containsKey(keyOne) && node.containsKey(keyTwo)) {
            if (node.get(keyOne).equals(valueOne) && node.get(keyTwo).equals(valueTwo)) {
                return mapper.writeValueAsString(node);
            }
        }
    }

    return null;
}