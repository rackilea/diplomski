JList list = new JList(...);
frame.add(new JScrollPane( list ), BorderLayout.CENTER);

JPanel buttonPanel = new JPanel(...);
buttonPanel.add( button1 );
frame.add(buttonPanel, BorderLayout, BorderLayout.LINE_END);