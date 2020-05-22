static String input(String inputprompt){

  System.out.print(inputprompt);
Scanner userInput;
userInput = new Scanner(System.in);
String input = userInput.nextLine();
return input;/* it is written as a new variable because it generates an
  error otherwise*/}

public static void main(String[] args) {
    String input = "useless for now"; /*this line is because it detects that there is no variable at
  the line where it assigns the value of input to text before the script runs*/
    String text = input("what would you like the following text to be");
    //the line refered to in previous comment
    System.out.print(text);
}