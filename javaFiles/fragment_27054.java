int cursor =0;
    String[] modeWords = new String[numberOfModes];
    for(int i=0; i<=tokens.length-2; i++){
        while(i+1 <= tokens.length-1 && tokens[i].equalsIgnoreCase(tokens[i+1])){
            wordValue++;
            i++;
        }
        if(wordValue==maxValue){
            modeWords[cursor]=tokens[i];
            cursor++;
        }
        wordValue=1;
    }
    return modeWords;
}