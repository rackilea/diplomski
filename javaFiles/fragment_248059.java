private void btnViewActionPerformed(java.awt.event.ActionEvent evt) { 
     SwingUtilities.invokeLater(() -> {
            initAndShowGUI();
    });
}
public void initAndShowGUI() {
    // This method is invoked on the EDT thread
    JFrame frame = new JFrame("Swing and JavaFX");
    final JFXPanel fxPanel = new JFXPanel();
    frame.add(fxPanel);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    Platform.runLater(() -> {
        initFX(fxPanel);
    });
}

private void initFX(JFXPanel fxPanel) {
    // This method is invoked on the JavaFX thread
    Scene scene = createScene();
    fxPanel.setScene(scene);
}

private Scene createScene() {
    try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ViewScreen.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root, Color.ALICEBLUE);
        Stage stage = new Stage();
        stage.setScene(scene);
        return (scene);

    } catch (IOException ex) {
        Logger.getLogger(LoginForm.class.getName()).log(Level.SEVERE, null, ex);
    }
    return null;
}