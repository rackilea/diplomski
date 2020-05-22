public ArrayList<String> readFileText (String filename){
    //ArrayList to hold all the lines
    ArrayList<String> lines = null;

    //Get lines of text (Strings) as a stream
    try (Stream<String> stream = Files.lines(Paths.get(filename))){
        // convert stream to a List-type object
        lines = (ArrayList<String>)stream.collect(Collectors.toList());
    }
    catch (IOException ioe){
        System.out.println("\nCould not read lines of text from the file.\n" +
                "Reason: parameter \"" + ioe.getMessage() + "\"");
    }
    catch (SecurityException se){
        System.out.println("Could not read the file provided." + 
          "Please check if you have permission to access it.");
    }

    lines.remove(0);  //Remove the first line of the file. Line at index 0.

    for(String line : lines)
        //Fine the first occurrence of white-space in each line,
        //and use that substring, to remove the number of the line.
        line = line.substring(line.indexOf(" "));

    return lines;
}