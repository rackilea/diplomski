ArrayList<String> words = new ArrayList<>();
BufferedReader reader = null;
try {
    reader = new BufferedReader(new FileReader(srcFile));
    String line;
    while ((line = reader.readLine()) != null) {
        line = line.trim(); // remove leading and trailing whitespace
        if (!line.isEmpty() && !line.equals("")) {

            words.add(line);
            System.out.println(line);
        }
    }