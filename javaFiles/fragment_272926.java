Connection con =
                    DriverManager.getConnection(connection, user, password);

            Statement st = con.createStatement();

            String sql = "select * from events";
            ResultSet rs = st.executeQuery(sql);
            ResultSetMetaData metaData = rs.getMetaData();

            int rowCount = metaData.getColumnCount();

            System.out.println("Table Name : " + metaData.getTableName(2));
            System.out.println("Field \tsize\tDataType");

            for (int i = 0; i < rowCount; i++) {
                System.out.print(metaData.getColumnName(i + 1) + " \t");
                System.out.print(metaData.getColumnDisplaySize(i + 1) + "\t");
                System.out.println(metaData.getColumnTypeName(i + 1));
            }