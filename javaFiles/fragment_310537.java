LinkedList<Book> books = ...;

private void getGenres(){
     List<Genre> genres = books.stream()
             .map(x -> x.getGenre())
             .distinct()
             .collect(Collectors.toList());
     for (Genre genre : genres){
            System.out.println(genre);
     }
}