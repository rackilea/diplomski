public static void main(String[] args) {
     // TODO code application logic here
    Scanner input = new Scanner(System.in);
      System.out.println("Enter Annual Interest Rate");

      //user input is 5.4% for example

      //this is where the problem is because a double data type cannot contain the % 
      symbol:

      String userInput = input.nextLine(); // "5.4%"

      double percentage = Double.parseDouble(userInput.replace("%", "")) / 100; // 0.54
      //You can now do calculations or anything you want with this value.

     //multiplying it with 100 to get it to % again
      System.out.println("Your Annual rate " + percentage*100 + "% is an error");
}