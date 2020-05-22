Scanner scanner = new Scanner(file)) {
int lineNum = 0;
while (scanner.hasNextLine()) {
    String line = scanner.nextLine();
    lineNum++;
    if(line.contains(" all ")){
        scanner.nextLine(); // this will skip to the next line
        System.out.println("I found it on line " +lineNum);
        // look for the integer value 30 and store it in Integer variable.
    }