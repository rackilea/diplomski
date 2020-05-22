private void onLaunchBrowser(ActionEvent evt) {
    URI uri = null;
    try {
        uri = new URI(txtBrowserURI.getText());
        desktop.browse(uri);
    } catch(IOException ioe) {
        System.out.println("The system cannot find the " + uri + 
             " file specified");
          //ioe.printStackTrace();
    } catch(URISyntaxException use) {
          System.out.println("Illegal character in path");
          //use.printStackTrace();
    }
}