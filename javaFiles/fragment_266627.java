public class TweetDao {
    private static final String SELECT_TWEETS = "SELECT COUNT(tid) as TC FROM TWEETS WHERE replyTo =  ? ";
    // inject this - setter or constructor
    private Connection connection;

    public int getTweetCount(int tid) throws SQLException {
        int tweetCount = -1;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = this.connection.prepareStatement(SELECT_TWEETS);
            ps.setInt(1, tid);
            rs = ps.executeQuery();
            while (rs.hasNext()) {
                tweetCount = rs.getInt("TC");
            }
        } finally {
            DatabaseUtils.close(rs);
            DatabaseUtils.close(ps);
        }
        return tweetCount;
    }
}