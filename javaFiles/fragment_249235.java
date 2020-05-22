public class Sami extends JFrame implements ActionListener {

   public static void main(String[] args) {
      (new Sami()).setVisible(true);
   }

   private JTextArea textArea;
   private JScrollPane scrollPane;
   private JButton moreTextButton = new JButton("More text!");
   private StringBuffer text = new StringBuffer("0 Silly random text.\n");
   private Point orig = new Point(0, 0);

   public Sami() {
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      getContentPane().setLayout(new BorderLayout());
      this.textArea = new JTextArea() {
         @Override
         public boolean getScrollableTracksViewportHeight() {
            return false;
         }
         @Override
         public boolean getScrollableTracksViewportWidth() {
            return false;
         }
      };
      this.scrollPane = new JScrollPane(this.textArea);
      getContentPane().add(this.scrollPane, BorderLayout.CENTER);
      this.moreTextButton.addActionListener(this);
      getContentPane().add(this.moreTextButton, BorderLayout.SOUTH);
      setSize(400, 300);
   }

   @Override
   public void actionPerformed(ActionEvent arg0) {
      int lineCount = this.text.toString().split("[\\r\\n]").length;
      this.text.append(lineCount + "The quick brown fox jumped over the lazy dog.\n");
      Point orig = this.scrollPane.getViewport().getViewPosition();
      // System.out.println("Orig: " + orig);
      this.textArea.setText(text.toString());
      SwingUtilities.invokeLater(new LaterUpdater(orig));
   }

   class LaterUpdater implements Runnable {
      private Point o;
      public LaterUpdater(Point o) {
         this.o = o;
      }
      public void run() {
         // System.out.println("Set to: " + o);
         Sami.this.scrollPane.getViewport().setViewPosition(o);
      }
   } 

}