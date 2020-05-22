//Some initialization code here...
Scanner myScanner = new Scanner(new File("myFile.txt"));
while(myScanner.hasNext()) {
    try {
        int myIntVariable = myScanner.nextInt();
    } catch (InputMismatchException ex) {
        System.out.println("Here's the token that caused the problem: " + myScanner.next());
    }
}
//The rest of your code here...