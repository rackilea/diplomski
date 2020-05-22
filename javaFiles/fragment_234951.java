BufferedReader in = new BufferedReader(new FileReader(f));
StringBuilder output = new StringBuilder();
try {
    while (in.hasNext()) {
        output.append(in.readLine());
        output.append("\n");
    }
finally {
    in.close();
}