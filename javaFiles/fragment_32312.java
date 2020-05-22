// for each line in the file
while (sc.hasNextLine()) {
    String line = sc.nextLine();
    System.out.println(line);

    // split the line into pieces of data separated by the spaces
    String[] data = line.split();

    String firstName = null;
    String lastName = null;

    // get the name from data[]
    // if the array length is greater than or equal to 1
    // then it's safe to try to get something from the 1st index (0)
    if(data.length >= 1)
        firstName = data[0];
    if(data.length >= 2)
        lastName = data[1];

    // what is the meaning of the numbers?

    // get numbers
    Double d1 = null;
    if(data.length >= 3){
        try {
            d1 = Double.valueOf(data[2]);
        } catch (NumberFormatException e){
            // couldn't parse the 3rd piece of data into a double
        }
    }

    Double d2 = null;
    // do the same...

    // do something with 'firstName', 'lastName', and your numbers ...
}