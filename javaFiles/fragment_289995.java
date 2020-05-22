@Override
public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Book book = (Book) o;

    if (Double.compare(book.price, price) != 0) return false;
    if (!author.equals(book.author)) return false;
    if (!title.equals(book.title)) return false;

    return true;
}