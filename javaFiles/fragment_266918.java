try {
    UIManager.setLookAndFeel ( "javax.swing.plaf.nimbus.NimbusLookAndFeel" );
} catch (ClassNotFoundException e) {
    e.printStackTrace();
} catch (InstantiationException e) {
    e.printStackTrace();
} catch (IllegalAccessException e) {
    e.printStackTrace();
} catch (UnsupportedLookAndFeelException e) {
    e.printStackTrace();
}
initComponents();
setVisible(true);
setDefaultCloseOperation(EXIT_ON_CLOSE);
pack();