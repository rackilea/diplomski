String word = returnUserInput();
this.counter = 0;
try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
    for (String line; (line = reader.readLine()) != null; ) {
        for (int i = 0; (i = line.indexOf(word, i)) != -1; i += word.length()) {
            this.counter++;
        }
    }
}