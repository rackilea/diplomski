FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
Parent root;

try {
    root = loader.load();
} catch (IOException ioe) {
    // log exception
    return;
}

// Color.TRANSPARENT allows use of rgba colors (alpha layer)
setScene(new Scene(root, Color.TRANSPARENT));