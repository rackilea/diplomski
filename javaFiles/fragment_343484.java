Path p1 = Paths.get("C:/Users/Green/documents/dictionary.txt");
 Scanner sc = new Scanner(p1.toFile()).useDelimiter("\\s*-\\s*");

 Map<String, String> dic = new HashMap<String, String>();

 while (sc.hasNext()) {      
    String word = (sc.next());
    dic.put(word, Translate(word));
 }


//print out from dictionary data

for(Map.Entry<String, String> entry: dic.entrySet()){
    System.out.println(dic.getKey() + " - "  + dic.getValue());
}