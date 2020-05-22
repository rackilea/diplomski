public class NamingStrategyWrapper implements NamingStrategy {
    private NamingStrategy target;

    public NamingStrategyWrapper(NamingStrategy target) {
        this.target = target;
    }

    public String columnName(String arg0) {
        if ("columnameA".equals(arg0)) return getColumnName();
        else return target.columnName(arg0);        
    }

    ...
}