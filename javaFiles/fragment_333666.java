PreparedStatement insertTable1;
PreparedStatement insertTable2;

void init(Connection c) {
    insertTable1 = c.prepareStatement(INSERT_TABLE1_QUERY);
    insertTable2 = c.prepareStatement(INSERT_TABLE2_QUERY);
}
void close() {
    insertTable1.close();
    insertTable2.close();
}
void condition1(Connection c, arg1, arg2) {
    insertTable1.setString(1, value1);
    insertTable1.setInt(2, value2);
    insertTable1.executeUpdate();
    c.commit();
}
void condition2(Connection c, arg1, arg2) {
    insertTable2.setString(1, value1);
    insertTable2.setInt(2, value2);
    insertTable2.executeUpdate();
    c.commit();
}