while(rs.next()) {
    System.out.println(rs.getString("melodie") + rs.getString("artist") + rs.getInt("an"));
    Melodii m = new Melodii(rs.getString("melodie"), rs.getString("artist"), rs.getInt("an"));
    lista.add(m);

    for (int i = 0; i < lista.size(); i++) {
        t.setText(m.toString());
    }
}