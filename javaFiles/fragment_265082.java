List<Client> clients = new ArrayList<>();
Client client=null;
      try {
            dbConnection = OpenConnexion.getDBConnection();
            statement = dbConnection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM client");
            while (result.next()) {
                client = new Client();
                client.setId(result.getInt(1));
                //Map other properties likewise here
               clients.add(client);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassCastException cce){
            System.out.println(cce.getMessage());
        } finally {
            maliste ==clients; // set list here
            if (statement != null) {
                statement.close();
            }
            if (dbConnection != null) {
                dbConnection.close();
            }
        }