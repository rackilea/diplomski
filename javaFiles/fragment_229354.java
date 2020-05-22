new ServerClientFrontEnd().startClient();

/* Create and display the form */
java.awt.EventQueue.invokeLater(new Runnable() {
    public void run() {
        new ServerClientFrontEnd().setVisible(true);
    }
});