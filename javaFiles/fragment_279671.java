public Integer methodOne(int[] numberArray, String[] stringArray){
    boolean check = false;
    for(int i = 0; i < stringArray.length; i++){
        if(!stringArray[i].equals(null)) {
            check = methodTwo(numberArray[i]);
        }
    }
    if(check == false){
        return -1;
    }
    else{
        return 0; //"RETURN SOMETHING ELSE HERE
    }
}

public boolean methodTwo(int number){
    return number > 0;
}