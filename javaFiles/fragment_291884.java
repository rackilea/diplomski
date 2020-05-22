try{
 java.sql.Statement mystat=connection.createStatement();
 String delete_jpg="DELETE FROM mytable WHERE mycol LIKE '%.jpg %' ";  //HERE YOU HAVE TO ADD A WHITE SPACE AFTER THE .jpg as you can also seen in your sample URL!
 mystat.executeUpdate(delete_jpg);
}catch(Exception e){
}