ResultSet rs = this.m_statement.executeQuery("SELECT * FROM CheckingAccountsTable");
    int columnCount = rs.getMetaData().getColumnCount();
    while (rs.next()) {
        for (int i = 1; i <= columnCount; i++) {
            System.out.print(rs.getString(i));
        }
        System.out.println();
    }