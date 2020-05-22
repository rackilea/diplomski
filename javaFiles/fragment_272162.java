result = Pstatement.executeQuery("SELECT * FROM usersList() ");
while(result.next()) {
    System.out.println(result.getString(("at")));
    System.out.println(result.getString(("name")));
    System.out.println(result.getString(("surname")));
}