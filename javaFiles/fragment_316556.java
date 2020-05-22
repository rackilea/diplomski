char[] newArray = new char[oldArray.length];
    for(int i = 0; i < oldArray.length; i++) {
        if(i % 5 == 0) {  //Every 5th element
            newArray[i] = ...what to change to here...;
        } else {
            newArray[i] = oldArray[i];
               }
}