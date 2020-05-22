private void displayListOfEmployee(){
     String sql = "Select * from employee";
     DB.getInstance().runQuery(sql, rs -> {
         while (rs.next())
             System.out.println(.....); // display value of column
     });
}