public class FrameGUI extends JFrame { // I'm not a fan of extending JFrames.
    // this variable is now visible throughout the class    
    private JTextArea textArea = new JTextArea(15, 40); // 15 rows, 40 columns

    public FrameGUI(String title) {
      super(title);
      setLayout(new BorderLayout());

      // final JTextArea textArea = new JTextArea();  //  *** commented out
      detailsPanel = new DetailsPanel();

      Container c = getContentPane();
      c.add(new JScrollPane(textArea), BorderLayout.CENTER); // put textarea into a scrollpane
      c.add(detailsPanel, BorderLayout.NORTH);
    }

    public void appendToTextArea(String text) {
      textArea.append(text);
    }