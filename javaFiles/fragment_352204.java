public final class Book {
    private final String title;
    private final List<Author> authors;
    ...
    public JComponent display() {
        JPanel bookPanel = new JPanel();
        bookPanel.add(new JLabel(title));
        JList authorsList = new JList(); // Or similar
        for (Author author: authors) {
            authorsList.add(author.display());
        }
        bookPanel.add(authorsList);
        return bookPanel;
    }
}