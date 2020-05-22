public interface DataTable {
    String getTableName();
    void setTableName(String tableName);
}
public interface Stat {// not really clear on what this is supposed to offer
    String getKey();
    void setKey(String key);
    String getValue();
    String setValue(String value);
}
public interface TableCollection {
    List<DataTable> getTables();
    void setTables(List<DataTable> tables);
    int getRemaining();//useful for not sending all if you have too much?
}