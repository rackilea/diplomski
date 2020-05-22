//connection to DB
    Class.forName("org.postgresql.Driver");
    try (Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Benerator","postgres","newPassword")) {

        //print the first two columns of table bank_card_people
        try (PreparedStatement stmt = con.prepareStatement("select * from public.bank_card_people");
                ResultSet res = stmt.executeQuery()) {
            while (res.next()) {
                System.out.println(res.getString(1)+ " " + res.getString(2));
            }
        }

        //add a line to the same table
        String sql = "insert into public.bank_card_people (\"first-name\", \"last-name\", \"card-number\") VALUES ('example','example','example')";
        try (PreparedStatement stmt2 = con.prepareStatement(sql)) {
            int updateCount = stmt2.executeUpdate();
        }

        // is supposed to print all the databases
        try (PreparedStatement stmt3 = con.prepareStatement("SELECT datname FROM pg_database WHERE datistemplate = false"));
                ResultSet res2 = stmt3.executeQuery()) {
            System.out.println("yes");
            while(res2.next()){
                System.out.println(res2.getString(1));
            }
        }
    }