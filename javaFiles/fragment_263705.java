XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "sql" })
@XmlRootElement(name = "sqlmap", namespace = "http://www.example.org/sqlmap/")
public class Sqlmap {
    @XmlElement(namespace = "http://www.example.org/sqlmap/")
    private List<SqlType> sql;

    public List<SqlType> getSql() {
        return sql;
    }

    public void setSql(List<SqlType> sql) {
        this.sql = sql;
    }
}