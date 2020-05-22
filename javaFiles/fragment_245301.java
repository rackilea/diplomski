Object name;
Scanner scan = new Scanner(System.in);
String answer = "";

do {
    name = new Object();
    name.method();

    System.out.print("Do you wish to continue entering data? ");
    answer = scan.nextLine().toLowercase(); //Get the response
} while(!answer.equals("yes"); //If they didn't enter yes then the loop stops