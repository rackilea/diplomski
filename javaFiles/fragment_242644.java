for (String string : nextLine) {
  date = DateUtil.convertToDate(string);

  if (null != date) {
    ps.setDate(index++, new java.sql.Date(date.getTime()));
  } 
  else {
     try {
       final double doubleValue = Double.parseDouble(string.replaceAll(",",""));

       ps.setDouble(index++, doubleValue);
     }
     catch(NumberFormatException e) {
       // For invalid double
       ps.setString(index++, string);
     }
  }