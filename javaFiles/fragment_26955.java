public List<Book> filterBooks(List<Book> readingList, String author) {
    List<Book> myList = new ArrayList<>();
    for (int i = 0; i < readingList.size(); i++) {
        if (readingList.get(i).getAuthor().equals(author)) {
            myList.add(readingList.get(i));
        }
    }
    return myList;
}