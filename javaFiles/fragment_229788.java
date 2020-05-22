public static void drawFrame(){
    // Create frame
    JFrame frame = new JFrame("Frame");
    // Set default close operation
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // Set frame attributes

    // !! Don't do this here...
    //frame.setVisible(true);
    // ... IMHO, better to use pack...
    //frame.setSize(400, 300);
    frame.setResizable(false);
    // Set Layout
    frame.setLayout(new BorderLayout());
    // Add Components
    frame.add(drawMenuBar(), BorderLayout.NORTH);
    JPanel twinPane = new JPanel();
    frame.add(twinPane, BorderLayout.CENTER);
    twinPane.setLayout(new GridLayout(1, 2));
    twinPane.add(drawForm());
    twinPane.add(drawInfo());

    // !! Do it here instead...
    frame.pack();
    frame.setVisible(true);
} // Ends method drawFrame