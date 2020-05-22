List<RowHolder> list = new LinkedList<RowHolder>();

while (rs.next())  {
    RowHolder holder = new RowHolder();
    holder.setName(rs.get("name"));
    holder.setSurname(rs.get("surname"));
    holder.setEmail(rs.get("email"));
    // etc. for all the relevant fields
    list.add(holder);
}