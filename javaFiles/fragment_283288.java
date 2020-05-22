Set<Genre> seen = new HashSet<>();
for(Book books:booksAvailable() ){

   Genre genre = books.getGenre();

   if (!seen.contains(genre)) {
       System.out.println(genre);
       seen.add(genre);
   }
}