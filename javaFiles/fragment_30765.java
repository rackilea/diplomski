int input = 0;
int count = 0;
int total = 0;
do{
    System.out.print("Enter an Integer: ");
    total += input;
    if(!scan.hasNextInt()) {
        scan.nextLine();
        System.out.println( "That is not an integer." );
        input = 0;
     } else {
         input = scan.nextInt();
         count++;
     }
 } while(input >= 0);

System.out.println("Count: " + (count - 1));
System.out.println("Total: " + total);