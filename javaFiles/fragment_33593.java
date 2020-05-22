import org.skife.jdbi.v2.sqlobject.customizers.Define;
...
@SqlUpdate("create table if not exists <table> (" +
        "startTime TimeStamp not null," +
        "stopTime TimeStamp not null," +
        "uuid varchar(255)" +
        ")")
public void createTable(@Define("table") String table);