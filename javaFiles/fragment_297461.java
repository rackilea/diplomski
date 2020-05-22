java.awt.EventQueue.invokeLater(new Runnable() {
    public void run() {
        try {
            dispose();
            new Class2().setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Class2().class.getName()).log(Level.SEVERE, null, ex);
        }
    }
});