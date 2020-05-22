Scanner kb = new Scanner(System.in);
System.out.println("Enter the number of your triangle (1 to 50):");
int userInput = kb.nextInt();//3
int minus = userInput -1;//2
int lineNumber = userInput + minus;//5
int half = (lineNumber / 2) + 1;//3

for(int i = 1; i <= half; i++){
    System.out.println("");
    for (int j = 1; j <= i; j++){
        System.out.print("*");
    }
}
for (int i = minus; i >= 1; i--){
    System.out.println("");
    for (int j = 1; j <= i; j++){
        System.out.print("*");
    }
}