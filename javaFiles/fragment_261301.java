private static final String QUERY_ASC = "SELECT * FROM "+TABLE_SONG_DETAILS +" WHERE "+TABLE_SONG_DETAILS+"."+"artist"+"=? ORDER BY track ASC";
private static final String QUERY_DESC = "SELECT * FROM "+TABLE_SONG_DETAILS +" WHERE "+TABLE_SONG_DETAILS+"."+"artist"+"=? ORDER BY track DESC";

private PreparedStatement queryAllSongsInfo = conn.prepareStatement(order==ORDER_BY_DESC?QUERY_DESC:QUERY_ASC);

// the user inputs the artist_name and ORDER
queryAllSongsInfo.setString(1, artist_name);