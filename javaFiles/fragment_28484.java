Sentence sentenceClass = null;

while(line!=null) {
  // file reading part  

  if (lang.equals("EN")){
    sentenceClass = new Sentence();
    sentences.add(sentenceClass);             
    sentenceClass.setFraseENG(sentence);
  } 
  else {
    sentenceClass.setTranslation(readLine[1]);
  }

  line=reader.readLine();
}