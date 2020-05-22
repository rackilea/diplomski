public static void main(String[] args) throws IOException {
    Map<String, Integer> words = new HashMap<String, Integer>();

    long before = System.currentTimeMillis();

    File dir = new File("c:/temp/files");
    for (File file : dir.listFiles()) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        for (String line = reader.readLine();  line != null;  line = reader.readLine()) {
            String[] lineWords = line.split("\\s+");
            for (String word : lineWords) {
                int count = 1;
                Integer currentCount = words.get(word);
                if (currentCount != null) {
                    count = currentCount + 1;
                }
                words.put(word, count);
            }
        }
    }

    long after = System.currentTimeMillis();

    System.out.println("run took " + (after - before) + " ms");
    System.out.println(words);
}