StringBuilder result = new StringBuilder();

BufferedReader reader = null;

try {
    reader = new BufferedReader(in);

    String line;

    while ((line = reader.readLine()) != null) {
        line = line.trim();
        if (line.length() > 0) {
            result.append(line);
            result.append('\n');
        }
    }
} catch (IOException e) {

}
finally {
    if (reader != null) {
        try {reader.close();} catch (IOException e) {}
    }
}

System.out.println(result.toString());