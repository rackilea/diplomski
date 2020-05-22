Scanner scan = new Scanner( System.in);
System.out.print( "Enter your name: ");
String name = scan.nextLine();

System.out.print( "Please enter a number between 1 and 10: ");
int number = scan.nextInt();

//asks for a number between one and ten until I get number within that range,
while (number < 1 || number > 10) {
    System.out.print( "No, between 1 and 10: ");
    number = scan.nextInt();
}


for (int i = 1; i <= number; i++) {
    if (i % 3 == 0) {
        System.out.print(name + " ");
    } else {
        System.out.print(i + " ");
    }
}