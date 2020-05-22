class Shelf {

    private String name;
    private Integer noOfBooksRequired;
    private String type;
    private List<String> books;

    public Shelf() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNoOfBooksRequired() {
        return noOfBooksRequired;
    }

    public void setNoOfBooksRequired(Integer noOfBooksRequired) {
        this.noOfBooksRequired = noOfBooksRequired;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<String> getBooks() {
        return books;
    }

    public void setBooks(List<String> books) {
        this.books = books;
    }
}