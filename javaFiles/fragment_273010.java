private void onLaunchMail(ActionEvent evt) {
    String mailTo = txtMailTo.getText();
    URI uriMailTo = null;
    try {
        if (mailTo.length() > 0) {
            uriMailTo = new URI("mailto", mailTo, null);
            desktop.mail(uriMailTo);
        } else {
            desktop.mail();
        }
    } catch(IOException ioe) {
        ioe.printStackTrace();
    } catch(URISyntaxException use) {
        use.printStackTrace();
    }
}