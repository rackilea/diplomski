Collections.sort(books, new Comparator<BookInfo>(){

        @Override
        public int compare(BookInfo book1, BookInfo book2) {
            Double p1 = book1.getRetailPrice();
            Double p2 = book2.getRetailPrice();
            return p1.compareTo(p2);
        }
    });