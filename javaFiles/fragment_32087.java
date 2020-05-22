public static void doIt(BufferedReader r, PrintWriter w) throws IOException {
    ArrayList<String> strings = new ArrayList<>();
    String line;
    while((line = r.readLine()) != null) {
        boolean isSmaller = false;
        for (int i = 0; i < strings.size()-1; i++) {
            if (line.compareTo(strings.get(i)) < 0) {
                isSmaller = true;
                break;
            }
        }
        strings.add(line);
        if (isSmaller) {
            w.println(line);
        }
    }
}