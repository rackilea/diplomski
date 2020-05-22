// remove data previously in the list
rmList.roomlist.clear();

while (rs.next()){
    rmList.roomlist.add(new ListRoom(rs.getString(1),
                                     rs.getString(2),
                                     rs.getString(3),
                                     rs.getString(4),
                                     rs.getString(5)));
}