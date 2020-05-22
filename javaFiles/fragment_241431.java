public void insertFruit(String fruit, String color){

       try(Connection connect = SQLHelperClass.connectOnly()){
         PreparedStatement pst = connect.prepareStatement("INSERT INTO practice (fruit, color) VALUES (?, ?);");

        pst.setString(1, fruit);
        pst.setString(2, color);

        pst.executeUpdate();

          }catch (SQLException e) {
            e.printStackTrace();
          }

}