ResultSet rs = stmt.executeQuery(sql);
            while (listSubTable.getRowCount() > 0) {
                ((DefaultTableModel) listSubTable.getModel()).removeRow(0);
            }
            int obColumns = rs.getMetaData().getColumnCount();
            System.out.println("obColumns: " + obColumns);
            while (rs.next()) {
                Object[] obRow = new Object[obColumns];
                obRow[0] = rs.getString(1);
                obRow[1] = rs.getInt(2);
                System.out.println(obRow[0]);
                System.out.println(obRow[1]);

           ((DefaultTableModel)listSubTable.getModel()).insertRow(rs.getRow() - 1, obRow);
            }