class Student {
    private int id;
    private Map<Integer, Library> libraries;
    private getLibrary(int id) {return libraries.get(id);}
}

class Library {
    private int id;
    private Map<Integer, Topic> topics;
    private getTopic(int id) {return topics.get(id);}
}

class Topic {
    private int id;
    private Map<Integer, Book> books;
    private getBook(int id) {return books.get(id);}
}

class Book {
    private int id;
    private String name;
}