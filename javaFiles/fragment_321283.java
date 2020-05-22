// Insert AddressBook
String sql1 = "INSERT INTO addressbook (id, name) VALUES (?,?)"
try (PreparedStatement stmt = conn.prepareStatement(sql1)) {
    stmt.setInt(1, addressBook.getId());
    stmt.setString(2, addressBook.getName());
    stmt.executeUpdate();
}

// Insert Contacts
String sql2 = "INSERT INTO contact" +
             " (id, firstname, lastname, email, phonenum)" +
             " VALUES (?,?,?,?,?)";
try (PreparedStatement stmt = conn.prepareStatement(sql2)) {
    stmt.setInt(1, addressBook.getId());
    for (Contact contact : addressBook.getContacts()) {
        stmt.setString(2, contact.getFirstName());
        stmt.setString(3, contact.getLastName());
        stmt.setString(4, contact.getEmail());
        stmt.setString(5, contact.getPhoneNum());
        stmt.executeUpdate();
    }
}