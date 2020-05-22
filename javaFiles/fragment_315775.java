String sql = "select * from leaves, type_applications, type_leaves " +
                "where leaves.type_leave = type_leaves.id and " +
                "leaves.type_application = type_applications.id";

ResultSet rs = stmt.executeQuery(sql);
DBTablePrinter.printResultSet(rs);