public class Test {
    public static void main(String[] args) throws Exception {
        List<Tweet> tweets = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        try(BufferedReader reader = new BufferedReader(new FileReader("tweet.json"))){
            String line;
            while((line = reader.readLine()) != null){
                tweets.add(mapper.readValue(line, Tweet.class));
            }
        }
    }
}