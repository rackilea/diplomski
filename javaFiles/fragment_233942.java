public static void resultSetPrinter(ResultSet rset) {
    try {
        if(rset.next()) {
            while(rset.next()) {
                String title = rset.getString("Title");
                String author = rset.getString("Author");
                int qty = rset.getInt("Qty");
                System.out.println("Title: " + title + "\nAuthor: " + author + "\nNumber in stock: " + qty + "\n");
            }
        } else {
            System.out.println("No records for the entry could be found.\n");
        }
    } catch(SQLException ex) {
        ex.printStackTrace();
    }
}