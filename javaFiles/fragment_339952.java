List<Map<String, String>> tweetList = new LinkedList<Map<String, String>>();
for (Status tweet : tweets) {
    Map<String, String> tweetResult = new LinkedHashMap<String, String>();
    tweetResult.put("username", tweet.getUser().getScreenName());
    tweetResult.put("status", tweet.getText());
    tweetResult.put("date", tweet.getCreatedAt().toString());
    tweetResult.put("retweets", String.valueOf(tweet.getRetweetCount()));
    tweetList.add(tweetResult);
}
String resultJson = new Gson().toJson(tweetList);
response.getWriter().write(resultJson);