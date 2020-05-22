String yourFirstString = "2.34";
String yourSecondString = "";

double yourFirstDouble = 0;
double yourSecondDouble = 0;

if(yourFirstString  != null && yourFirstString.trim().length() > 0){
  try {
     yourFirstDouble = Double.parseDouble(yourFirstString); 
  }catch(NumberFormatException e){
    // handle Exception here
  }
}

// same parsing for the second double

PreparedStatement stmt = conn.prepareStatement("insert into table (col, col2) value(?, ?)");
stmt.setDouble(1, yourFirstDouble);
stmt.setDouble(2, yourSecondDouble);
stmt.executeUpdate();