List<Feeds> mFeeds = new ArrayList<>(); //If you are using Java 7+ you do not need to declare explicitly the Type in Diamonds. If you aren't, ignore this. Also fixed name to adapt to Java standards.

//add all feeds objects
m_feeds.add(...);

HashMap<String, Integer> repeatedDatabase = new HashMap<>(); //See Above.

for (Feeds f : m_feeds){
    String s = f.date; //Suggestion: use a getter method, do not make public variables accessible outside class
    Integer i = repeatedDatabase.get(s);
    if (i == null){
        repeatedDatabase.put(s, 1);
    } else {
        repeatedDatabase.put(s, i+1);
    } 
}