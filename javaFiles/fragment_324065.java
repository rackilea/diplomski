public final void processLineByLine() throws IOException, ClassNotFoundException, SQLException {
    try (Scanner scanner =  new Scanner(fFilePath, ENCODING.name())){
        String nextLine = null;
        if(scanner.hasNextLine()){
            nextLine = scanner.nextLine();
        }
        PrintWriter out = new PrintWriter("D:/output.txt");
        while (nextLine!=null){
            nextLine = processLine(nextLine, scanner, out);
        } 
        out.close();
    }
}

protected String processLine(String aLine, Scanner scanner, PrintWriter out) throws FileNotFoundException, SQLException {

    String nextLine = null;

        if (aLine.startsWith("#*")) {
            title = aLine.substring(2);
            Line = title;
        } 
        else if (aLine.startsWith("#@")){
            author = aLine.substring(2);
            Line = Line + "\t" + author;
        }
        else if (aLine.startsWith("#t")){
            year = aLine.substring(2);
            Line = Line + "\t" + year;

        }
        else if (aLine.startsWith("#c")){
            conference = aLine.substring(2);
            Line = Line + "\t" + conference;
        }
        else if (aLine.startsWith("#index")){
            index = aLine.substring(6);
            Line = Line + "\t" + index;
        }
        else if (aLine.startsWith("#%")){
            cite = aLine.substring(2);
            while(scanner.hasNextLine() && (nextLine = scanner.nextLine()).startsWith("#%"))
            {
                cite += "," + nextLine.substring(2); 
            }   
            Line = Line + "\t" + cite;

            out.append(Line);
        } 
        if(nextLine== null && scanner.hasNextLine()){
            nextLine = scanner.nextLine();
        }       
    return nextLine;
}