while (rs.next()) {
    Vector v = new Vector<>();
    v.add(rs.getString(1));
    v.add(rs.getString(2));
    v.add(rs.getString(3));
    v.add(rs.getString(4));
    v.add(rs.getString(5));
    myVector.add(v);
}