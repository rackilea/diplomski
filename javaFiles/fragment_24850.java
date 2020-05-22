JLabel label= new JLabel( "hello" );
label.setForeground( null );
label.setFont( null );
JTextField textField = new JTextField(10);
textField.setForeground( null );
textField.setFont( null );

JPanel panel = new JPanel();
panel.setForeground( Color.RED );
panel.setFont( new Font("monospaced", Font.PLAIN, 24) );

panel.add( label );
panel.add( textField );