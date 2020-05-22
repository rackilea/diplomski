public Card_panel()
{

    setPreferredSize(new Dimension(WIDTH, HEIGHT));
    setBackground (Color.green.darker().darker());

    setLayout(new GridBagLayout());
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.gridwidth = 2;

    ImageIcon image = new ImageIcon(imageList[0]);
    JLabel label = new JLabel("", image, JLabel.CENTER);
    add( label, gbc );

    gbc.gridx = 0;
    gbc.gridy++;
    gbc.gridwidth = 1;
    JButton higher = new JButton("Higher");
    higher.setActionCommand("higher");
    higher.addActionListener (this);
    add( higher, gbc );

    gbc.gridx++;
    JButton lower = new JButton("Lower");
    lower.setActionCommand("lower");
    lower.addActionListener (this);
    add( lower, gbc );


}