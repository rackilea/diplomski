StringBuilder builder = new StringBuilder();
for(String word : words){
    String lower = word.toLowerCase();
    if(doNotCapitalize.contains(lower){
          builder.append(lower).append(" ");
    }
    else{
          builder.append(WordUtils.capitalizeFully(lower)).append(" ");
    }
 }
 String finalString = builder.toString();