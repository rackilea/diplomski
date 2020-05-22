// read the first line from the text file
String line = br.readLine();

// loop until all lines are read
while (line != null) {

    // use string.split to load a string array with the values from
    // each line of
    // the file, using a comma as the delimiter
    String[] attributes = line.split(" ~ ");
    if (attributes.length == 2) {
        String[] nameValue = attributes[1].split(": ");
        if (nameValue.length == 2) {
            Metrics valueOfMetric = createMetric(nameValue);
            // adding book into ArrayList
            metricsss.add(valueOfMetric);
        }
    }

    // read next line before looping
    line = br.readLine();
}