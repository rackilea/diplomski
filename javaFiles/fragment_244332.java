String insertGame = "insert into games (game_name, game_genre, game_year) "
        + "values (?, ?, ?)";
    try (PreparedStatement statment = connection.prepareStatement(insertGame)) {
        statment.setString(1, game.getName());
        statment.setString(2, game.getGenre());
        statment.setInt(3, game.getYear());
        statment.executeUpdate();
    }