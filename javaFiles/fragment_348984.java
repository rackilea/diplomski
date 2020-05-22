new ClosingInputStream(
        stream,
        new CompositeCloseable(
                stream,
                new ResultSetCloser(resultSet),
                new PreparedStatementCloser(statement),
                new ConnectionCloser(connection)
            )
    );