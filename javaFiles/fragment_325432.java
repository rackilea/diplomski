Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

// Make sure where in the top left corner, please lookup how
// to find the screen insets ;)
setLocation(0, 0);
setSize(dim);
// Set undecorated
setUndecorated(true);
// Apply a transparent color to the background
// This is ALL important, without this, it won't work!
setBackground(new Color(0, 255, 0, 0));

// This is where we get sneaky, basically where going to 
// supply our own content pane that does some special painting
// for us
setContentPane(new ContentPane());
getContentPane().setBackground(Color.BLACK);
setLayout(new BorderLayout());

// Add out image pane...    
ShowImage panel = new ShowImage();
add(panel);

setVisible(true);