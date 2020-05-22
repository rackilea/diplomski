String [] nextLine;
// Read from the csv sequentially until all the lines have been read.
while ((nextLine = reader.readNext()) != null) {
    // nextLine[] is an array of values from the line
    System.out.println(nextLine[0] + nextLine[1] + "etc...");
}