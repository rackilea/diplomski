newWord = newWord.trim(); // This would remove trailing and leading spaces
    String [] words = newWord.split("\\s+"); //split them on spaces
    StringBuffer sb = new StringBuffer();
    for(int i=0;i<words.length-1;i++){
        sb.append('$');
        sb.append(words[i]);
        sb.append(' ');
    }
    if(words.length>0){
        sb.append('$');
        sb.append(words[words.length-1]);
    }
    newWord = sb.toString();