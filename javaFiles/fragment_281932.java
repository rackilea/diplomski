try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
    String input = in.readLine();
    toggleStringCase(input);
} catch (IOException e) {
    e.printStackTrace();
}