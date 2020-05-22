for(String str : list) {
    String everything = str.trim();
    int lastPos = everything.lastIndexOf(' ');
    if(lastPos < 0){
       continue; //check if there is a space char
    }
    String lastWord = everything.substring(lastPos + 1);
    String restWords = everything.substring(0,lastPos)
    lastlist.add(lastWord);
    restlist.add(restWords);
}