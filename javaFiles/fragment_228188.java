Scanner sc = new Scanner(System.in);
//how many lines should be taken
int lines = sc.nextInt(); 

//read the carret! This is, the line break entered by user when presses Enter
sc.nextLine();

// initialize input array
String[] longWords = new String[lines] ;

//set the input from the user into the array
for (int i = 0; i < longWords.length; i++) {
    longWords[i] = sc.nextLine() ;
}