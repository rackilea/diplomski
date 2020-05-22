List<String> wordList = new ArrayList<String>();

try {
    BufferedReader br = new BufferedReader(new FileReader("words.txt"));
    String line;
    while((line = br.readLine().trim()) != null) {
        wordList.add(line);
    }
} catch (IOException ex){
    ex.printStackTrace();
}