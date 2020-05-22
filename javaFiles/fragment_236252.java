ArrayList<ArrayList<String>> lines = new ArrayList<>();
try {
    BufferedReader reader = new BufferedReader(new FileReader(fileName));
    String line = null;
    while ((line = reader.readLine()) != null) {
        ArrayList<String> tokens = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(line, ",");
        while (st2.hasMoreElements()) {
            tokens.add(st2.nextElement());
        }
        lines.add(tokens);
    }
}