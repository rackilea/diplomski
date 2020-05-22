public class ColorBoxes {
  private int grid = 12;
  private int pause = 50;

  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
        public void run() {
            ColorBoxes applet = new ColorBoxes();
            if (args.length > 0) {
              grid = Integer.parseInt(args[0]);
            }
            if (args.length > 1) {
              pause = Integer.parseInt(args[1]);
            }
            JFrame frame = new JFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new GridLayout(grid, grid));
            for (int i = 0; i < grid * grid; i++){
                frame.add(new CBox(pause));
            }
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        }
    });
  }

}