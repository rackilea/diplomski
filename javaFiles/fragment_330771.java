public static void main(String[] args) {
    Random rand = new Random();
    int counter = 0;
    for(int i = 0; i <= 10; i++){
        if(craps(rand)) counter++;
    }

    System.out.println("You won " + counter + " times!");
}