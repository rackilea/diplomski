List<Foo> selectFoos(Connection connection) throws SQLException {
    PreparedStatement ps = connection.prepareStatement("select * from foo");
    try {
        ResultSet resultSet = ps.executeQuery();
        try {
            List<Foo> foos = new ArrayList<Foo>();
            while (resultSet.next()) {
                Foo foo = new Foo();
                // use resultSet methods get... to retrieve data from current row of results
                // and populate foo
                foos.add(foo);
            }
        } finally {
            resultSet.close();
        }
    } finally {
        ps.close();
    }
    return foos;
}