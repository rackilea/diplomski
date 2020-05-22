String fileName = "input.txt";
File file = new File(fileName);
Scanner scanner = new Scanner(file);
String s = "";
while(scanner.hasNextLine()){
    s = scanner.nextLine();
    // your code. You can also use scanner.next() to read word by word instead of nextLine()
}