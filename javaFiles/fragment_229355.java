/* Create and display the form */
java.awt.EventQueue.invokeLater(new Runnable() {
    public void run() {
        ServerClientFrontEnd fontEnd = new ServerClientFrontEnd();
        fontEnd.startClient();
        fontEnd.setVisible(true);
    }
});