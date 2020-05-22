Set<String> genres = new HashSet<>();
for(Book books:booksAvailable() ){
   Genre genre = books.getGenre();
   genres.add(genre.getName());
}

 for(String genre : genres) {
       System.out.println(genre);
 }