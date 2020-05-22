public void negativeNumbers(){
    int negative = 0;
    for (int i = 0; i <= size; i++){
        if (i < 0) {
            negative = negative + 1;
        }
        System.out.println("There are "+ negative +" negative elements in the list!");  
    }
}