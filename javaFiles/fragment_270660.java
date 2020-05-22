Cursor cursor = qb.query(
    db, 
    sqlSelect, 
    "firstName || ' ' || lastName LIKE ?", 
    new String[]{"%" + name + "%"}, 
    null, null, null
);