public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int num=2;   // you need to initialize num with a value, that allows you to go inside the while loop at least once
    int count = 0;

    while((num != 0) && (num < 31) && (num % 2 == 0) || (num % 3 == 0)) {
        System.out.println("Enter the players' numbers");  
        num = input.nextInt();   // user input is here inside the loop
        count++;  // your count will count every valid input + the user input that ends the loop
    }
    count--;  // if your user entered 0 to exit the loop, count would have still incremented, so you need do subtract one again
    System.out.println(count + " players can be goalkeepers.\n");
}