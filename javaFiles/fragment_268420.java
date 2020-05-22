int number;
System.out.println("enter a number between 1 and 8");
do {
      while (!console.hasNextInt()) {
            console.nextLine(); // consume input
            System.out.println("not an integer. try again");
      }

      number = Integer.parseInt(console.nextLine());
      if(number < 1 || number > 8)
          System.out.println("number is not between 1 and 8 try again ");

} while (number < 1 || number > 8);
// do something with number