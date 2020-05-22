for(int i = 0; i < list.size(); i++){
    int currentNumber = list.get(i);

    if((currentNumber % 2) == 0){
        list.add(currentNumber * currentNumber);
    }
}