String[] badWords = {"word1", "word2", ...};
for (int i=0; i<badWords.length; i++){

  if(event.getMessage().contains(plugin.getConfig().getString("PBSwears.words." + badWords[i]))){
     String message = event.getMessage().replaceAll(plugin.getConfig().getString("PBSwears.blocked." + badWords[i]), plugin.getConfig().getString("PBSwears.replace." + badWords[i]));
     event.setMessage(message);
  }
}