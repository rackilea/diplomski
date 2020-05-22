enum Suit{
 CLUBS   ("clubs", 0),
 DIAMONDS("diamonds", 1),
 HEARTS  ("hearts", 2),
 SPADES  ("spades", 3);

 private final String name;
 private final int value;
 private static final HashMap<String, Suit> suitByName;
 static {
    suitByName = new HashMap<String, Suit>();
    for (Suit s: Suit.values()){
        suitByName.put(s.name, s);
    }
 }

 Suit(String name, int value){
     this.name = name;
     this.value = value;
 }
 public int getValue(){
    return this.value;
 }

 public static Suit fromString(String card){
    return suitByName.get(card.toLowerCase());
 }
}