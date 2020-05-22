// Init the regex here
String rx = "([0-9]+)>";

// Then the part where you read the lines
String line = reader.readLine();
while (line != null) {
    String[] chunks = line.split("\\s+"); // Split with whitespace
    if (chunks.length > 2) { // chunks[2] = 200 / 300 values
        Matcher m = p.matcher(line); // Init Matcher to find all numbers at the end of >
        int val = 0;
        while (m.find()) {  // Find multiple occurrences numbers before >
            val += Integer.parseInt(m.group(1)); // Group 1 contains the number, summing up
        }
        res.add(chunks[2]);
        res.add(Integer.toString(val));
    }
    line = reader.readLine();
}
System.out.println(res); // => [200, 2, 300, 1, 200, 2]