MyMainPanel mainPanel = new MyMainPanel();
LoginPanel loginPanel = new LoginPanel();

JFrame mainApp = new JFrame();
mainApp.add( mainPanel );
mainApp.pack();
mainApp.setVisible(true);

JDialog dialog = new JDialog( mainApp, true );
dialog.add( loginPanel );
dialog.setVisible( true );

if( login.isAuthenticated() ) { // after dialog is dismissed we can set the user
    mainPanel.setAuthenticatedUser( loginPanel.getAuthenticatedUser() );
} else {
    System.exit(-1);
}