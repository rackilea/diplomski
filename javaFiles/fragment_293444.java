public static ArrayList<Object[]> resultSetToTableModel(ResultSet row) throws SQLException {

        ArrayList<Object[]> classList = new ArrayList<Object[]>();
        ResultSetMetaData meta = row.getMetaData();

        Object cols[] = new Object[meta.getColumnCount()];
        for (int i = 0; i < cols.length; i++) {
            cols[i] = meta.getColumnLabel(i + 1);
        }
        classList.add(cols);

        while (row.next()) {
            Object data[] = new Object[cols.length];
            int quizColumn = -1;
            try {
                quizColumn = row.findColumn(DBHelper.MJLADB_QUIZTABLE_QUIZOBJECT_A);
                if (quizColumn > 0) {
                    System.out.println("greater than 0");
                }
            }
            catch (SQLException e) {
                quizColumn = -1;
            }

            for (int i = 0; i < data.length; i++) {
                if (quizColumn == (i + 1)) {
                    byte[] buf = row.getBytes(i + 1);
                    ObjectInputStream objectIn = null;
                    if (buf != null) {
                        try {
                            objectIn = new ObjectInputStream(new ByteArrayInputStream(buf));
                            data[i] = objectIn.readObject();
                        } catch (IOException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        } catch (ClassNotFoundException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }

                    }

                }
                else {
                    data[i] = row.getObject(i + 1); 
                }
            }
            classList.add(data);
        }

        return classList;
    }