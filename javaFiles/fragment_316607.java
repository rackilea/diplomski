public int[] ReadNumbersFromFile(String name) throws FileNotFoundException {
    //String to store each number from the file
    String token1 = "";

    //Open the file and create a scanner to read it
    Scanner inFile1 = new Scanner(new File(name));

    //temporary arrayList to store what we read from the file
    //scanners return strings
    ArrayList<String> temps = new ArrayList<String>();

    // while the scanner can see it has more to read
    while (inFile1.hasNext()) {
        // save the number read
        token1 = inFile1.next();

        //add it to the arrayList
        temps.add(token1);
    }

    //close the scanner when done using to free up that resource
    inFile1.close();

    //create the standard int array that is the same length as the arrayList<String>
    int[] tempsArray = new int[temps.size()];

    //loop through the arrayList<String>
    //this is what contains each number from the file, just as Strings
    for(int i = 0; i < temps.size(); i++) {
        //Integar.parseInt(String s) takes a string of numbers and returns it as int
        //save this to our int[]
        tempsArray[i] = Integer.parseInt(temps.get(i));
    }

    //return the int[]
    return tempsArray;
}