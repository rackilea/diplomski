public static Table<?> myTable() {
    if (something)
        return DSL.table("{0}_01", MY_TABLE);
    else if (somethingElse)
        return DSL.table("{0}_02", MY_TABLE);
    ...
}