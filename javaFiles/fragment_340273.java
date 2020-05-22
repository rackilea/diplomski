List<String> imageURLs = new ArrayList<String>();
try {
    BufferedReader reader = request.getReader();
    String line;
    do {
        line = reader.readLine();
        imageURLs.add(line);
    } while (line != null);