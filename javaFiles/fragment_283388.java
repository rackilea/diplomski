private static void createAndShowGui() {
  // Model model = new MyModel();
  View view = new View();
  // Control control = new MyControl(model, view);

  JFrame frame = new JFrame("My GUI");
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  frame.getContentPane().add(view.getMainComponent());
  frame.pack();
  frame.setLocationByPlatform(true);
  frame.setVisible(true);
}

public static void main(String[] args) {
  SwingUtilities.invokeLater(new Runnable() {
     public void run() {
        createAndShowGui();
     }
  });
}