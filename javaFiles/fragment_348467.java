try (BufferedReader br = new BufferedReader(new FileReader("bookList.txt"))) {
    String word;
    int lineCount = 0;
    while ((word = br.readLine()) != null ){
        if (++lineCount % 2 == 0) {
            numbers.add(Integer.parseInt(word));
        } else {
            books.add(word);
        }
    }
} catch (IOException e) {
    e.printStackTrace();
}