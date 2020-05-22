LineNumberReader reader = new LineNumberReader(new FileReader("input.txt"));

for (String line = reader.readLine(); line != null; line = reader.readLine()) {
    if (reader.getLineNumber() > 400) {
        break; // we're done
    } else if (reader.getLineNumber() >= 200) {
        // do something with 'line'
    }
}