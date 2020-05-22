Query query = session.createQuery(
    "select 
        count(ist.id), 
        ist.name 
    from OrderDetails od 
    inner join od.itemSubtype ist 
    where od.employee = 1 
    group by ist.name"
);
for(Object rows : query.list()){
    Object[] row = (Object[]) rows;
    Number count = (Number) row[0];
    String itemSubTypeName = (String) row[1];
}