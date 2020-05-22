class ItemWithTransaction {
    Item item;
    Connection conn; // connection associated with this item
    boolean rollback;
}

stream
    .map(i -> new ItemWithTransaction(i, openTransaction()))
    .map(i -> i.conn.executeSql(..., i.item.prop1))
    . ...
    .map(i -> { 
        if (...) i.rollback = true; // error related to this item
        return i;
    })
    . ...
    .subscribe(i -> {
            ...
            if (i.rollback) i.conn.rollback();
            else i.conn.commit();
            i.conn.close();
        },
        e -> rollbackAndCloseAllOpenConnections(),
        () -> {...})