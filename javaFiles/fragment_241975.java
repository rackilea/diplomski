try
        {
          // create a mysql database connection
          String myDriver = "org.gjt.mm.mysql.Driver";
          String myUrl = "jdbc:mysql://LOCATION/DATABASE"; 
          Class.forName(myDriver);
          Connection conn = DriverManager.getConnection(myUrl, "root", "");

          // create a sql date object so we can use it in our INSERT statement
          Calendar calendar = Calendar.getInstance();
          java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());

          // the mysql insert statement
          String query = " insert into TABLE (first_name, last_name, phone_number, email_adress)"
            + " values (?, ?, ?, ?)";

          // create the mysql insert preparedstatement
          PreparedStatement preparedStmt = conn.prepareStatement(query);
          preparedStmt.setString (1, firstname);
          preparedStmt.setString (2, lastname);
          preparedStmt.setString (3, phonenumber);
          preparedStmt.setString (4, emailadress);

          // execute the preparedstatement
          preparedStmt.execute();

          conn.close();
        }
        catch (Exception e)
        {
          System.err.println("Got an exception!");
          System.err.println(e.getMessage());
        }
      }