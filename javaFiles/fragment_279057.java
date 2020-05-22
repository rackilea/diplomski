class Book implements Comparable<Book> {
    // Your Rest of the code...

    // Rest of the code ...
    @Override
    public int compareTo(Book o) {
        if(o == null) {
            return 1;
        }
        if (this == o) {
            return 0;
        } else {
            if(this.title != null && o.title != null) {
                return this.title.compareTo(o.title);
            } else if(this.title != null) {
                return 1;
            } else {
                return -1;
            }
        }
    }
}