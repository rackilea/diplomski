try(PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
    setParameters(parameterValues, statement);

    statement.execute();

    try(ResultSet rs = statement.getGeneratedKeys()) {
      if(rs.next()) {
        return rs.getObject(1);  // <-- contains the generated key
      }

      return null;
    }
  }