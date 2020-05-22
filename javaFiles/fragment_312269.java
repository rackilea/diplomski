Scanner input = new Scanner(System.in);
char letter;

System.out.println("Hello! \n");
System.out.println("Please select a number between 1-26!");
int user = input.nextInt(); 
while (user<1 || user>260)  {
   System.out.println("Sorry, your number is invalid.");
    user=input.nextInt();
}
 System.out.println("Now, enter a letter!");
 letter = input.next().charAt(0);
 while (letter<0 || user+letter>90)  {
     System.out.println("The letter should not be negative and too high");
     letter=input.next().charAt(0);
 }
 System.out.println((char) (user+letter));
}