public Window(final JPanel panel)
{
    super("Knight Quest");
    //loading screen
    final JWindow window = new JWindow();
    window.getContentPane().add(new JLabel("Loading..."));
    window.getContentPane().add(
            new JLabel("", new ImageIcon(getClass().getResource("loading.gif")), SwingConstants.CENTER));
    window.setBounds(600, 300, 400, 300);
    window.setVisible(true);
    javax.swing.Timer timer = new javax.swing.Timer(2500,
        new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                window.setVisible(false);
                setLayout(new BorderLayout());
                add(panel, BorderLayout.CENTER);
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                setSize(600,550);
                setLocation(525, 225);
                setVisible(true);
            }
        }
    );
    timer.setRepeats(false);
    timer.start();
}