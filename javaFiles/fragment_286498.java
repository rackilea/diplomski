ResultSet rset = null;
try {
            String userName = "data";

            String password = "data";

            String url = "jdbc:mysql://localhost/playdb";

            // Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(url, userName, password);
            Statement stmt = con.createStatement();
            System.out.println("Connected database successfully...");
            String strSelect = "select * from computer";

            //statement.setString(1, name);
            rset = stmt.executeQuery(strSelect);

            while(rset.next()) {   // Move the cursor to the next row
                String name = rset.getString("name");

                int    id   = rset.getInt("id");
                System.out.println( name + ", " + id);
                // ++rowCount;
            }


        }
        catch(SQLException e) {
            e.printStackTrace();
            System.out.println("cant Connected database successfully...");
        }
        Form<Computer> computerForm = form(Computer.class);
      return ok(
        createForm.render(computerForm,rset)
    );