public static void screen() {
    JFrame myFrame = new JFrame("Yore");
    myFrame.setAlwaysOnTop(true);
    myFrame.setResizable(false);
    myFrame.setForeground(Color.BLACK);
    myFrame.setSize(300,365);
    myFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    myFrame.setVisible(true);
    myFrame.setBackground(Color.WHITE);
    JPanel panel = new JPanel();
    myFrame.setContentPane(panel);
    JTextField Username = new JTextField();
    Username.setText("Username");
    Username.setColumns(10);
    panel.add(Username); 

  panel.validate();

  }