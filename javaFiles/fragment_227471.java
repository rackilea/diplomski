public static <T> Tag getRows(int id) throws SQLException {
    String query = "SELECT * FROM Tag WHERE id = ?";

    //Unexpected type error
    T<Tag> list = null;

    ResultSet rs = null;