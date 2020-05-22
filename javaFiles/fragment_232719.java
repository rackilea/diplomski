PreparedStatement ps = connection.prepare("SQL_DELETE_STUDENT_BY_ID");

for (Student student : students) {
  ps.setInt(1, student.getId());
  ps.executeUpdate();
}

ps.close();