public List<Contact> getContacts() {
   // ... your database connection and query code here

   this.rs = this.stmt.executeQuery(query);

   List<Contact> contacts = new LinkedList<Contact>();

   while (rs.next()) {

      int id = rs.getInt("node_id");                               
      String name = rs.getString("node_name");
      String parent = rs.getString("node_parent");
      String level = setLvl(rs.getInt("level"));

      contacts.add(new Contact(id, name, parent, level));
   }

   //... the rest of your database handling code, don't forget to close the connection

   return contacts;
 }