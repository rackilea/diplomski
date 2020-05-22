boolean isPresent = books.stream()
     .anyMatch(book -> book.getTitle().equals(inputBook.getTitle()));

if(isPresent){
     ...  console print
} else {
     add it to books
}