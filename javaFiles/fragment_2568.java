JScrollPane scrollpane = new JScrollPane(); 
       String categories[] = { "1. Problem One Problem One Problem One Problem One Problem One Problem One Problem One Problem One Problem One", "2. Problem Two", "3. Extended Family", "4. Extended Family", "5. Extended Family"
               ,"6. Extended Family","7. Extended Family","8. Extended Family","9. Extended Family"};
       JList list = new JList(categories);

       scrollpane = new JScrollPane(list);

       JPanel panel = new JPanel(); 
       panel.add(scrollpane);

       scrollpane.getViewport().add(list);
       JOptionPane.showMessageDialog(null, scrollpane, "Error List",  
                                              JOptionPane.PLAIN_MESSAGE);