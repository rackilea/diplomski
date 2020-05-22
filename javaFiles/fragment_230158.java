public @interface Column {
      String name();
      String type();
}
public @interface Columns {
    Column[] value();
}

@Columns({@Column(name="id", type="long"), @Column(name="username",type="string")})
public void test() {}