private static hashmap _books = new ConcurrentHashMap<String,Book>();


public static Book getBookFromMap(String title ){
    return _books.get(title);
}