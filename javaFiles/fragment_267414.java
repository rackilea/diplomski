private final List<String> words = new ArrayList<String>();
private final Random random = new Random();

public String randomWord() throws IOException {
    if (words.isEmpty()) {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("../image/ListeMot.txt")));
        String line;
        while ((line = br.readLine()) != null)
            words.add(line);
        br.close();
    }
    return words.get(random.nextInt(words.size()));
}