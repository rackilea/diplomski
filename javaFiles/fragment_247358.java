String [] nextLine;
while ((nextLine = reader.readNext()) != null) {
    if(nextLine.length == 1) {
        // Do something with the first element, nextLine[0]
        System.out.println(nextLine[0]);
    }
    else if(nextLine.length == 2) {
        // Do something with both nextLine[0] and nextLine[1]
        System.out.println(nextLine[0] + ", " + nextLine[1]);
    }
    // Continue depending on how you want to handle the different rows.
}