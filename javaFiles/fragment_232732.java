public static void main(String[] args) {

    // To take input.
    Scanner scan = new Scanner(System.in);

    System.out.print("Enter Word: ");
    String word = scan.next(); // taking the word from user

    // moving first letter to the end.
    String newWord = word.substring(1) + word.charAt(0);

    // reversing the newWord.
    String reversed = new StringBuffer(newWord).reverse().toString();

    // printing output.
    System.out.println("You have entered '"+word+"'. "
            + "Is "+newWord+" same as "+word+"? "
            +reversed.equals(word)+".");

    // closing the input stream.
    scan.close();

}