public static void addComponentsToPane(Container pane) {

if (RIGHT_TO_LEFT) {
    pane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
}

MyPanel array;
JButton button;
pane.setLayout(new GridBagLayout());
GridBagConstraints c = new GridBagConstraints();

if (shouldFill) {
    c.fill = GridBagConstraints.HORIZONTAL;
}

button = new JButton("Reset to 0");
pane.add(button, c);

array = new MyPanel();
pane.add(myPanel, c);

}

private static void createAndShowGUI() {
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
addComponentsToPane(frame.getContentPane());
frame.pack();
frame.setVisible(true);
}



public static void main(String[] args) {
   javax.swing.SwingUtilities.invokeLater(new Runnable() {
        public void run() {
            createAndShowGUI();
        }
  });
}