public static void main(String a[]) throws IOException{
    String firstSentence = "I like chicken salad, it's my favorite food";
    String secondSentence = "This book contains tons of recipes on making all sorts of food, including cakes, chicken salad, etc";
    String[] firstSentenceWords = firstSentence.replaceAll("[.,]", "").split(" ");
    Set<String> overlappingPhrases = new HashSet<String>();     
    String lastPhrase = "";     
    for(String word : firstSentenceWords){
        if(lastPhrase.isEmpty()){
            lastPhrase = word;
        }else{
            lastPhrase = lastPhrase + " " + word;
        }
        if(secondSentence.contains(word)){
            overlappingPhrases.add(word);
            if(secondSentence.contains(lastPhrase)){
                overlappingPhrases.add(lastPhrase);
            }
        }else{
            lastPhrase = "";
        }
    }
    System.out.println(overlappingPhrases);
}