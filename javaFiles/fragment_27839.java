String comma="";
 StringBuilder allGenres = new StringBuilder();
 for (String g: genre) {
    allGenres.append(comma);
    allGenres.append(g);
    comma = ", ";
 }

 String query = "INSERT into featuredfilms_INFO (movieId, genres)" + "VALUES (?, ?)";
 PreparedStatement preparedStmt = conn.prepareStatement(query);
 preparedStmt.setString (1, ID);
 preparedStmt.setString (2, allGenres.toString());