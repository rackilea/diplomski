public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       JFrame frame = new JFrame();
       JXMapKit kit = new JXMapKit();
       JPanel parentPanel = new JPanel();
       parentPanel.setLayout(new BorderLayout());
       parentPanel.add(kit, BorderLayout.CENTER);
       frame.setContentPane(parentPanel);
       frame.pack();
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setVisible(true);
   }

}