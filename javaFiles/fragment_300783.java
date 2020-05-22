String Y="Hello.beautiful.world.how.are.you";
    int firstIndex=0;
    int nextIndex=Y.indexOf(".",firstIndex);

    String newString = "";
    while(nextIndex != -1){
        newString += Y.substring(firstIndex==0 ? firstIndex : firstIndex+1, nextIndex);
        newString += Y.substring(firstIndex==0 ? firstIndex : firstIndex+1, nextIndex);
        firstIndex=nextIndex;
        nextIndex=Y.indexOf(".", nextIndex+1);
    }

    System.out.println(newString);