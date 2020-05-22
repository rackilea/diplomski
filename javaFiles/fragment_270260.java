public static void main(String[] args) {
    // Creating ArrayLists
    List<List<String>> mylist = new ArrayList<>();
    String mypassword;

    System.out.println("Pleaseinput your passphrase:");
    // Getting user input (Password)
    Scanner in = new Scanner(System.in);
    mypassword = in.nextLine();

    // Beginning for loop to create array lists for each character
    // in the password      
    for (int i = 0; i < mypassword.length(); i++) { 
        List<String> firstCharAndMore = new ArrayList<>();
        char c = mypassword.charAt(i);
        firstCharAndMore.add(String.valueOf(c));
        if ('q' == c) {
            firstCharAndMore.add("hello");
        }
        mylist.add(firstCharAndMore);
    }
    System.out.println(mylist.toString());
}