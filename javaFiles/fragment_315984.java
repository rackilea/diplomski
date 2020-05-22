FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/EditMahasiswa.FXML"));
  // Loading your fxml here
  ....
  // get your EditController, cast it to the right class and use the setter to pass your variable 
  EditMahasiswaController editController = (EditMahasiswaController ) loader.getController();
  editController.setKampusModel(yourModel);