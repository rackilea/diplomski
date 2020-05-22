String text = "Its a sunny day today Its not gonna rain today";
Map<String,Integer> map = new HashMap<String, Integer>();
for( String word : text.split(" ")) {
    Integer i = map.get(word);
    if( i == null ) {
        map.put(word, 1);
    } else {
        map.put(word, i+1);
    }
}