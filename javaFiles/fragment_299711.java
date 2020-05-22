String tableName = year + "_KLCommissions";
// TODO: Put validation here unless you already have *complete confidence*
// that the value of "year" can't be messed around with.
String sql = "SELECT SUM(Premium), SUM(AgentComm) " +
             "FROM " + tableName + " " +
             "WHERE AgentCode = ?";

PreparedStatement preparedStatement = conn.prepareStatement(sql);
preparedStatement.setString(1, agent.getAgentNumber());
ResultSet resultSet = preparedStatement.executeQuery();