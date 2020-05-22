try {

       dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER,
                DB_PASSWORD);
                    System.out.println("Connection Good");
       try(Statenent st = dbConnection.createStatement();)
       {
          try(ResultSet res = st.executeQuery("SELECT 1 AS C"))
          {
              if(res.getInt("C") != 1)
                  throw  new SQLException();
          }
       }
    } catch (SQLException e) {

        System.out.println(e.getMessage());
                    System.out.println("Connection BAD");

    }

    return dbConnection;

}