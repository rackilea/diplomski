public class References {

    // First, initialise all unique keys
    public static final UniqueKey<TAuthorRecord> SysPk_14655 = 
        createUniqueKey(TAuthor.T_AUTHOR, TAuthor.ID);


    // Then initialise all foreign keys
    public static final Reference<TBookRecord, TAuthorRecord> SysFk_14666 = 
        createReference(SysPk_14655, TBook.T_BOOK, TBook.AUTHOR_ID);
    public static final Reference<TBookRecord, TAuthorRecord> SysFk_14667 = 
        createReference(SysPk_14655, TBook.T_BOOK, TBook.CO_AUTHOR_ID);


    // Factory method for unique keys
    protected static <R extends Record> UniqueKey<R> 
    createUniqueKey(Table<R> table, TableField<R, ?>... fields) {

    // Factory method for foreign keys referencing unique keys
    protected static <R extends Record, U extends Record> Reference<R, U> 
    createReference(UniqueKey<U> key, Table<R> table, TableField<R, ?>... fields) {

}