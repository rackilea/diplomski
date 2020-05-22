JPanel main = new JPanel( new BorderLayout() );

JComboBox comboBox = new JComboBox(...);
main.add(comboBox, BorderLayout.PAGE_START);

JPanel card = new JPanel( intervalLayout );
main.add(card, BorderLayout.CENTER);

frame.add( main );