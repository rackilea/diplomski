JFrame frame = new JFrame();
frame.setType( Type.UTILITY );
frame.setUndecorated( true );
final JFXPanel mainJFXPanel = new JFXPanel();
frame.getContentPane().add( mainJFXPanel );

mainJFXPanel.setScene( getScene() ); //The "getScene()" is just a placeholder