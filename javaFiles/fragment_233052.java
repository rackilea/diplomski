public Game[] getGameInfo(){
    String sql = " SELECT GameInfo.GameID" +
                       ", GameInfo.mapname" +
                       ", SUM(IIF(C.map = GameInfo.mapname,1,0)) AS CharacterCount" +
                   " FROM ( SELECT Character.map" +
                            " FROM [Character]" +
                            " JOIN Player ON Player.[ID] = Character.PlayerID" +
                         ") C" +
                  " RIGHT JOIN GameInfo ON GameInfo.mapname = C.map" +
                  " GROUP BY GameInfo.GameID" +
                          ", GameInfo.mapname";
    try (ResultSet rs = dbm.queryDatabase(sql)) {
        List<Game> games = new ArrayList<>();
        while (rs.next())
            games.add(new Game(rs.getInt("GameID"),
                               rs.getString("mapname"),
                               rs.getInt("CharacterCount")));
        return games.toArray(new Game[games.size()]);
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Failed to get Games");
        e.printStackTrace();
        return null;
    }
}