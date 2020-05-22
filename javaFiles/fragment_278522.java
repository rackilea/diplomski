public void showDialog(String sURL){
    final Stage myDialog = new Stage();
    myDialog.initStyle(StageStyle.UTILITY);
    myDialog.initModality(Modality.APPLICATION_MODAL);

    URL url = getClass().getResource(sURL);

    FXMLLoader fxmlloader = new FXMLLoader();
    fxmlloader.setLocation(url);
    fxmlloader.setBuilderFactory(new JavaFXBuilderFactory());
    try {
        Node n = (Node) fxmlloader.load(url.openStream());

        Scene myDialogScene = new Scene(VBoxBuilder.create().children(n).alignment(Pos.CENTER).padding(new Insets(0)).build());

        myDialog.setScene(myDialogScene);
        myDialog.showAndWait();
    } catch (Exception ex) {
        System.out.println(ex);
    }
}