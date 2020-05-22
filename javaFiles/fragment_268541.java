private static void createAndShowGUI() {
    mainFrame frame = new mainFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setResizable(false);
    frame.setLocationRelativeTo(null);
    addComponentsToPane(frame.getContentPane());
    frame.init();            <<<<<================== Don't forget about meeeee!
    frame.pack();
    frame.setVisible(true);
}

@Override
public void actionPerformed(ActionEvent e) {
    if ("one".equals(e.getActionCommand())) {
        System.out.println("hello");
    }
}