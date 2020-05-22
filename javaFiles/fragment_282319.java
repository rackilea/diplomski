JTextArea textArea = new JTextArea();
textArea.setLineWrap( true );
textArea.setWrapStyleWord( true );
textArea.setText("one two three four five six seven eight nine ten");
System.out.println("000: " + textArea.getPreferredSize());
textArea.setSize(100, 1);
System.out.println("100: " + textArea.getPreferredSize());
textArea.setSize( textArea.getPreferredSize() );