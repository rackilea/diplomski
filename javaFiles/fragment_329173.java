BufferedReader in = ....;
String inputLine = "";

// test for null here when reading in from the Reader
while ((inputLine = in.readLine()) != null) {
    // use inputLine here
}
// close BufferedReader here, usually in a finally block