@NamedNativeQueries({
    @NamedNativeQuery(
    name = "finDesiredData",
    query = "select * from mytable t where t.entry SIMILAR TO :ent",
        resultClass = MyTable.class
    )
})