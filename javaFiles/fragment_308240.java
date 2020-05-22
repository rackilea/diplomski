while (rs.next()) {
    for (int i = 1; i <= numberOfColumns; i++) {
        if (i > 1)
            System.out.print(",  ");

        String columnValue = rs.getString(i);
        name[i]=columnValue;
        System.out.println(name[i]);          //Everything executes well till here
    }
  }