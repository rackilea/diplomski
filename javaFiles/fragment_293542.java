public ArrayList<String> readAllLines(String filename){
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
    return lines;
}