PreparedStatementCreatorFactory preparedStatementCreatorFactory = new PreparedStatementCreatorFactory(
         "insert into PIZZA (name, createdAt) values (?, ?)",
         Types.VARCHAR, Types.TIMESTAMP
 );

// By default, returnGeneratedKeys = false so change it to true
preparedStatementCreatorFactory.setReturnGeneratedKeys(true);

 PreparedStatementCreator psc =
         preparedStatementCreatorFactory.newPreparedStatementCreator(
                    Arrays.asList(
                            pizza.getName(),
                            new Timestamp(pizza.getCreatedAt().getTime())));