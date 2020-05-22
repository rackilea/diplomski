TableAPI tableH = kvstore.getTableAPI();
/* 
 * get the Table, but be careful about doing this frequently,
 * as it performs a remote call.
 */
Table myTable = tableH.getTable("myTable");
PrimaryKey key = myTable.createPrimaryKey();

try {

    /* create and use an iterator on the Row value */
    TableIterator<Row> rowIter = tableH.tableIterator(key, null, null);
    while (rowIter.hasNext()) {
        Row row = rowIter.next();
        /* do something */
    }

    /* 
     * Or...
     * create and use an iterator on the PrimaryKey values.
     * This is much faster than fetching the data as well if
     * you only need fields in the primary key.
     */
    TableIterator<PrimaryKey> keyIter =
              tableH.tableKeysIterator(key, null, null);
    while (keyIter.hasNext()) {
        PrimaryKey key = rowIter.next();
        /* do something */
    }
} catch (FaultException fe) {
}