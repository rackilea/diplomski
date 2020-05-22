JDialog.setDefaultLookAndFeelDecorated(true);
    JDialog dialog = new JDialog(frame, "Test");
    dialog.getLayeredPane().getComponent(1).setFont(new Font("Lucida",Font.PLAIN,48));  
    dialog.setSize(300,100);  
    dialog.setLocation(400,200);  
    dialog.setVisible(true);