public class BookRecord extends CustomRecord<BookRecord> {
    protected BookRecord() {
        super(BookTable.BOOK);
    }
}

public class BookTable extends CustomTable<BookRecord> {
    public static final BookTable                      BOOK       = new BookTable();

    public static final TableField<BookRecord, Short>  ID         
      = createField("ID", SQLDataType.SMALLINT, BOOK);
    public static final TableField<BookRecord, String> TITLE      
      = createField("TITLE", SQLDataType.VARCHAR, BOOK);

    protected BookTable() {
        super("BOOK", DSL.schema(DSL.name("schema")));
    }

    @Override
    public Class<? extends BookRecord> getRecordType() {
        return BookRecord.class;
    }
}