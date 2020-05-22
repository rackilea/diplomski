File file = new File("yourFilePath.txt");  // create File object to read from
Scanner scanner = new Scanner(file);       // create scanner to read
Printwriter writer = new PrintWriter("someOutputFile.txt"); // create file to write to

while(scanner.hasNextLine()){  // while there is a next line
    String line = scanner.nextLine();  // line = that next line

    // do something with that line
    String newLine = "";

    // replace a character
    for (int i = 0; i < line.length(); i++){
        if (line.charAt(i) != '*') {  // or anything other character you chose
            newLine += line.charAt(i);
        }
    }

    // print to another file.
    writer.println(newLine);
}