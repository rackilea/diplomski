public Catalogue() {
        this.genres = new LinkedList<Genre>();
        Genre programming = new Genre("Programming");
        Genre drama = new Genre("Drama");
        this.genres.add(programming);
        this.genres.add(drama);

        booksAvailable.add(new Book("Swift", 1999, programming, 20));
        booksAvailable.add(new Book("TheAlChemist", 2000, drama, 20));
        //Name of a book, year of publication, genre, price
    }