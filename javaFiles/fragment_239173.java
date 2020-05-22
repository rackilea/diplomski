JTextArea textArea = new JTextArea("Insert your Text here");
JScrollPane scrollPane = new JScrollPane(textArea);  
textArea.setLineWrap(true);  
textArea.setWrapStyleWord(true); 
scrollPane.setPreferredSize( new Dimension( 500, 500 ) );
JOptionPane.showMessageDialog(null, scrollPane, "dialog test with textarea",  
                                       JOptionPane.YES_NO_OPTION);