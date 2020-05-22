query="UPDATE dipendenti SET ruolo=? WHERE ID_dipendente=?";
PreparedStatement statement = null;
statement=connessione.prepareStatement(query);
statement.setString(1,ruolo);
statement.setString(2,caratteristiche[1]);
int count = statement.executeUpdate();