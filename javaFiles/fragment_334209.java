public class SQLServer2000UnicodeDialect extends SQLServerDialect {

    public SQLServer2000UnicodeDialect(){
        super();
        ...
        registerColumnType( Types.CLOB, "ntext" );
        registerColumnType( Types.LONGVARCHAR, "ntext" );

        ...
    }
}