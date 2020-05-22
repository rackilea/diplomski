while(rs.next()) { // this tiny little '{' is reeeaaaally important here
            System.out.println(rs.getString("title"));
            System.out.println(rs.getString("description"));
            System.out.println(rs.getString("author"));
            System.out.println(rs.getString("publisher"));
            System.out.println(rs.getString("yearPublished"));
}