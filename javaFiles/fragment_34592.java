Knight myKnight = new Knight();


JOptionPane.showMessageDialog( null, "Welcome young knight.\n" );

String name = JOptionPane.showInputDialog( "What is your name? \n" );
myKnight.setKnightName( name );
String welcomeMessage = String.format( "Welcome, %s, to Kiev!", myKnight.getKnightName() );
...