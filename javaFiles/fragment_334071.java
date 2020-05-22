ResultSet results = myStatement.executeQuery("SELECT * FROM systemaccount where ID = "+getValue);

    ResultSetMetaData meta = results.getMetaData();
    while (results.next()) {
      Object[] data = new Object[meta.getColumnCount()];
      for (int index = 1; index <= data.length; index++) {
          data[index - 1] = results.getObject(meta.getColumnName(index));
          System.out.println("Column " + index + " is named " + meta.getColumnName(index) + " having value " + data[index - 1]);
      }
      // fname.setText(data[0].toString());
      ...
    }