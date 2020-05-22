@Entity(name = "BOOK_EMBEDDED")
@SQLInsert( sql = "insert into BOOK_EMBEDDED (BOOK_NAME, group_no, version) values (?, ?, ?)")
public static class Book implements Serializable {

    @EmbeddedId
    private EmbeddedKey key;

    @Column(name = "BOOK_NAME")
    private String bookName;

    @Version
    @Column(insertable = false)
    private Integer version;

    public EmbeddedKey getKey() {
        return key;
    }

    public void setKey(EmbeddedKey key) {
        this.key = key;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
}