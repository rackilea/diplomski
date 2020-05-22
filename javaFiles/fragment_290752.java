File log= new File("log.txt");
String search = "textFiles/a\\.txt";  // <- changed to work with String.replaceAll()
String replacement = "something/bob.txt";
//file reading
FileReader fr = new FileReader(log);
String s;
try {
    BufferedReader br = new BufferedReader(fr);

    while ((s = br.readLine()) != null) {
        s.replaceAll(search, replacement);
        // do something with the resulting line
    }
}