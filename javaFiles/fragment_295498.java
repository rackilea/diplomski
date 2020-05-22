File file = new File("D:\\graph\\temp.log");
FileReader fr = new FileReader(file);
LineNumberReader lineReader = new LineNumberReader(fr);

// skip the lines you don't need 

while (lineReader.getLineNumber() < count) {
    lineReader.readLine();
}

// begin processing input here