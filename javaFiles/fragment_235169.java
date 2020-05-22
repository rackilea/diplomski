class Book implements Comparable<Book>{
        public String title;
        public int weight;

        public Book(int weight, String title) {
            this.weight = weight;
            this.title = title;
        }

        @Override
        public int compareTo(Book anotherBook) {
            return weight - anotherBook.weight;
        }
    }