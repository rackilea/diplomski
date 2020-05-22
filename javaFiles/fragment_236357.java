BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("data.csv"), encoding));
    String line;
    while ((line = in.readLine()) != null) {
        StringTokenizer tokenizer = new StringTokenizer(line, "|");

        ...
    }