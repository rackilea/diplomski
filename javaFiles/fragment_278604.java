PreparedStatement stmt = connection.prepareStatement(
  "insert into collect.survey (id, name, idml) values (?, ?, ?)");
stmt.setInt(1, surveyId);
stmt.setString(2, survey.getName());
stmt.setString(3, idml);
stmt.executeUpdate();