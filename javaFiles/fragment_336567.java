public void displayTextMatch(String key) {
    // iterate through list
    for (Book book : bookList) {
        // call Book's containText method
        if (book.containsText(key)) {
            // assuming Book has a decent `toString()` override:
            System.out.println(book);
        }
    }
}