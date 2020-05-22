http://www.programmingsimplified.com/java/tutorial/java-while-loop

Scanner input = new Scanner(System.in);
System.out.println("Input an integer"); 

while ((n = input.nextInt()) != 0) {
  System.out.println("You entered " + n);
  System.out.println("Input an integer");
}

System.out.println("Out of loop");