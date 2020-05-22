Collections.sort(books, new Comparator<BookInfo>(){

        @Override
        public int compare(BookInfo book1, BookInfo book2) {
            Double p1 = book1.getRetailPrice();
            Double p2 = book2.getRetailPrice();
            int res = p1.compareTo(p2);
            if(res == 0){
                return book1.getTitle().compareTo(book2.getTitle());
            }
            return res;
        }
    });