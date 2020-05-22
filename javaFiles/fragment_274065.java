DBConnection dbConn = new DBConnection();
Connection conn = dbConn.connect();

PreparedStatement pstmt = null;

try{
        String SQL  = "SELECT `username`,`password` FROM `Clinician` WHERE `username` =? AND `password` = ?;";
        pstmt = conn.prepareStatement(SQL);