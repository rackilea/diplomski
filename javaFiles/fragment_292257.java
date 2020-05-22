try {
    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
} catch(ClassNotFoundException|InstantiationException
        |IllegalAccessException|UnsupportedLookAndFeelException ex) {
    Logger.getLogger(LaFColors.class.getName()).log(Level.SEVERE, null, ex);
    System.exit(1);
}
UIManager.put("Panel.background", Color.YELLOW);
UIManager.put("Button.foreground", Color.BLUE);
JFrame frame=new JFrame("Test");
frame.getContentPane().add(new JButton("See, it’s still "
   +UIManager.getLookAndFeel().getName()+" LaF"), BorderLayout.NORTH);
frame.setSize(200, 200);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setVisible(true);