public boolean borrowBook(String title, String author){     
    if (book1 == null){
        book1 = new Book(title, author);
        book1.getTitle(title);   // I don't know what you need these for?
        book1.getAuthor(author); // ???
        return true;    

    }else if (book2 == null){
        book2 = new Book(title, author);
        book2.getTitle(title);
        book2.getAuthor(author);
        return true;

    }else if (book3 == null){
        book3 = new Book(title, author);
        book3.getTitle(title);
        book3.getAuthor(author);
        return true;

    }else{
        return false;
    }   
}