public static void main(String[] args) throws FileNotFoundException {
    HashMap<String, List<String>> map = new HashMap<>();
    try (Scanner read = new Scanner (new File("E:\\blabla.txt"))) {
        read.useDelimiter("::");
        String tweet;
        while(read.hasNext())
        {
            tweet = read.next();
            String[] split = tweet.split(":");
            String key = split[0];
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(split[1]);
        }
    }
}