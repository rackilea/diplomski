try{
   ...
   dane = zadanie.executeQuery();
}catch(SQLException e) {
   e.printStackTrace();
} finally {
   zadanie.close();
}