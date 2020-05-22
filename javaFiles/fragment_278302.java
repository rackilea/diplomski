//read in the file one line at a time
BufferedReader in = new BufferedReader(new FileReader("input.xml"));
FileOutputStream fos = new FileOutputStream("output.xml");
try {

    StringBuilder sb = new StringBuilder();
    String l = "";
    String nl = System.getProperty("line.separator");

    //get next line, assign it to l, and make sure it exists. The line after the last in the file will always be null
    while((l = in.readLine()) != null) {
        //replace the desired substrings of each line
        if(l.contains("PrimeLineNo")) {
            l = l.replaceAll("PrimeLineNo", "LineNumber");
        }
        if(l.contains("SubLineNo")) {
            l = l.replaceAll("SubLineNo", "SubLineNumber");
        }
        //add the line to a string buffer to be written to file later
        sb.append(l + nl);
    }   

    //after we have gone through the entire input file, write it to the output file
    fos.write(sb.toString().getBytes());
}
catch(Exception e) {
    System.out.println("An unknown error occurred");
}
finally {
    //ensure the streams will always close
    in.close();
    fos.close();
}