JPanel left = new JPanel( new BorderLayout() );
left.add(leftLabel, BorderLayout.PAGE_START);
left.add(listScrollPane, BorderLayout.CENTER);

JPanel right = ...

JPanel main = new JPanel( new GridLayout(0, 2) );
main.add( left );
main.add( right );

frame.add( main );