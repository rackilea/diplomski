...
try {
    Connection connection = DBConnectionManager.getConnection();
    final String query = "SELECT user_post, post_time FROM wall_post WHERE user_id = " +
            "(SELECT user_id FROM user_info WHERE user_email = ?);";

    PreparedStatement preparedStatement = connection.prepareStatement(query);
    preparedStatement.setString(1, email);
    ResultSet resultSet = preparedStatement.executeQuery();

    while (resultSet.next()) {
        posts.add(new Post(resultSet.getString("user_post"),resultSet.getString("post_time")));
    }
    postBundle = new PostBundle("200","SUCCESS!",posts);
    return postBundle;         
}
...