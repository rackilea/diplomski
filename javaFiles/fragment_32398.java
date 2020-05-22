for (int i = 0; i < splitInput.length; i++){
    if (splitInput[i].equals("@") && i != 0 && i != splitInput.length -1){
        int max = Math.max(Integer.parseInt(splitInput[i - 1]), Integer.parseInt(splitInput[i + 1]));
    }
    //...
}