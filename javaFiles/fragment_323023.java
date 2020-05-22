public String printInfo () {
    totalPages();
    String info = "Book Title: " + title + "\n";
    info += "Book Author: " + author + "\n";
    info += "Year: " + year + "\n";
    info += "Number of pages: " + totalPages + "\n";
    return info;
}