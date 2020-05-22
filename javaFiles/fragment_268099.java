List<String> listSentences = new ArrayList<>(); 
String tmp = "";

for (String s : listWords) {
    tmp = tmp.concat(" " + s);
    if (s.endsWith("\"")){
        listSentences.add(tmp);
        tmp = "";
    }
}