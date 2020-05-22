public ObservableList<Game> buildTableModel() {

    try (Connection conn = DriverManager.getConnection(MapperConfig.JDBC_URL)) {
        PreparedStatement queryOpgeslagenGames = conn.prepareStatement("");
        ResultSet rs = queryOpgeslagenGames.executeQuery("SELECT spellen.spelID, spellen.spelNaam AS 'Naam van Spel', group_concat( naam separator ', ') AS 'Deelnemende spelers' FROM spellen RIGHT JOIN spelers ON spellen.spelID =     spelers.spelID GROUP BY spellen.spelID");
        // data of the table
        ObservableList<Game> games = FXCollections.observableArrayList();
        while (rs.next()) {
            String id = rs.get(1);
            String saveFileName = rs.get(2);
            String[] playerNames = rs.get(3).split(", ");
            Game game = new Game(id, saveFileName, playerNames);
            games.add(game);
        }
        return games ;
    } catch (SQLException ex) {
        for (Throwable t : ex) {
            t.printStackTrace();
        }
    }
    return FXCollections.observableArrayList();
}