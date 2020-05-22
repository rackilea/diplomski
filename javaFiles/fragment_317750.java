ps = conn.prepareStatement ("SELECT * FROM tbl WHERE ?='Gord'");
ps.setString(1, "FirstName");

ps = conn.prepareStatement ("SELECT * FROM ? WHERE FirstName='Gord'");
ps.setString(1, "tbl");

ps = conn.prepareStatement ("? * FROM tbl WHERE FirstName='Gord'");
ps.setString(1, "SELECT");