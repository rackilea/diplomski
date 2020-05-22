JButton firstButton = ...;
firstButton.addActionListener( myFirstButtonActionListener );

JButton secondButton = ...;
secondButton.addActionListener( mySecondActionListener );

//add them to a UI
contentPane.add( firstButton );
contentPane.add( secondButton );