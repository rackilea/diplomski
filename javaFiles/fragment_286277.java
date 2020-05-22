actionFirstSplit = line.split(" ");
try{
    actionSecondSplit = actionFirstSplit[2].split(",");
}catch (ArrayIndexOutOfBoundsException){
    //perform actions to handle out of bounds
}