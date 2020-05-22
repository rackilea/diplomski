public void GetTotalValue(){
    total = 0; // <---- ADD THIS RESET

    for (int i = 0; i<numCards; i++){
        value = hand[i];
        total += value;
    }

    int finalValue = total%10;

    System.out.print("Your hand value is: "+ finalValue);
}