while(rs.next()) {
    System.out.println(rs.getString("melodie") + rs.getString("artist") + rs.getInt("an"));
    Melodii m = new Melodii(rs.getString("melodie"), rs.getString("artist"), rs.getInt("an"));
    // just store all the results from the database, no need to iterate it at this point
    lista.add(m);
}
// instead, iterate the list afterwards and append the text
for (int i = 0; i < lista.size(); i++) {
    t.append(m.toString());
}