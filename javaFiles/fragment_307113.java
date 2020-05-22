@Entity
public class Table1 {
    @ManyToMany
    @JoinTable(name = "Table2")
    @MapKey(name = "key")
    private Map<String, Table3> table3s;

    ...
}

@Entity
public class Table3 {
    @Column(name = "tkey")
    private String key;

    @Column(name = "tvalue")
    private String value;

    ...
}