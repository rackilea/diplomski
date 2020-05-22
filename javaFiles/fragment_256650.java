public void deleteCar(ActionEvent actionEvent) {
     ConnectionClass connectionClass=new ConnectionClass();
     Connection connection=connectionClass.getConnection();
     PreparedStatement ps;
     String sql = "DELETE FROM `cars` WHERE `Plate Number` = ? ";

     try {
         ps = connection.prepareStatement(sql);
         stmt.setString(1, plateNum.getText());
         ps.executeUpdate();
     } catch (SQLException e) {
         e.printStackTrace();
     }

     Alert alert = new Alert(Alert.AlertType.INFORMATION);
     alert.setTitle("Database Confirmation");
     alert.setHeaderText("Success!");
     alert.setContentText("Data Successfully added to Database");
     alert.showAndWait();

     plateNum.setText("");
     dateReserved.setValue(null);
}