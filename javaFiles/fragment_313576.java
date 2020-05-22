private static final String SQL_CREATE_TABLE_BOOKS = "CREATE TABLE " + BOOKS_TABLE + "("
        + BOOK_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
        + BOOK_NAME + " TEXT NOT NULL, "
        + BOOK_AUTHOR + " TEXT NOT NULL, "
 //How to relate BookStore with Store_ID here?
        + " FOREIGN KEY ("+ BOOKStore +") REFERENCES "+STORE_TABLE+"("+STORE_ID+"));";