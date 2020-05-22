String sentence ="Meow test test hello test.";

    String[] temp = sentence.split("[|!|\\?|.|\\s|\\n]");
    String word = temp[temp.length-1];
    int index = sentence.lastIndexOf(word);
    String out = sentence.substring(0,index) + " INSERTED WORD" + sentence.substring(index+word.length(), sentence.length());