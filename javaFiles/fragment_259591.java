Scanner scan = null;
if (args[0] == null) {
    scan = new Scanner(System.in);
} else {      
    scan = new Scanner(testFile);
}