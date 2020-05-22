public class TableMetadata<E extends Enum & TableColumn> {
    private Map<Integer, TableColumn> columns = new HashMap<Integer, TableColumn>();

    public TableMetadata(Class<E> c) {
        for (E e: c.getEnumConstants()) {
            columns.put(e.getIndex(), e);
        }
    }

    public String getColumnName(int index) {
        return columns.get(index).getName();
    }
}

public class GenericFormatter<E extends TableColumn> extends BaseFormatter {  
    private TableMetadata<E> m;  

    public GenericFormatter(TableMetadata<E> m) {  
         this.m = m;
    }  

    public String getColumnName(int columnNumber) {  
        return m.getColumnName(index);
    }  

    //...  
}