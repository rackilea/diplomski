updateGame.setInt(1, game.Id);
Timestamp timestamp = new Timestamp(100,2,2,2,2,2,2);
updateGame.setTimestamp(2,timestamp);
updateGame.setString(3, game.GameName);
updateGame.setTime(4, (Time) game.Time);
updateGame.setString(5, game.MapVersion);
updateGame.setString(6, game.Mode);