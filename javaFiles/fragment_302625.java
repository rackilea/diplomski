BufferedReader reader = new BufferedReader(new FileReader("input.txt"));

// skip to the 200th line
for (int n = 0; n < 199 && reader.readLine() != null; ++ n)
    ;

// process the next 201 (there's 201 lines between 200 and 400, inclusive)
String line;
for (int n = 0; n < 201 && (line = reader.readLine()) != null; ++ n) {
    // do something with 'line'
}