public void start()
{
    // Create a new panel, make 'content'  refer to it
    content = new JPanel();

    // Set the content pane of the window to the panel we just created
    f.setContentPane(content);

    // Create a button group and some buttons
    ButtonGroup group=new ButtonGroup();
    JButton b1=new JButton("Instructions");
    JButton b2=new JButton("Play");
    JButton b3=new JButton("Exit");

    // Set the layout of the content panel and add buttons
    content.setLayout(new FlowLayout());
    content.add(b1);
    content.add(b2);
    content.add(b3);

    // Create and add the intro panel and instruction panel to the content panel
    content.add(introPanel(),FIRST_PANEL);
    content.add(instructionPanel(),SECOND_PANEL);

    f.setSize(750,360);
    f.setDefaultCloseOperation(EXIT_ON_CLOSE);
    f.setVisible(true);

    // Add a listener to the 'Instructions' button
    // so that the cardLayout is shown when the button is clicked
    b1.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            cardLayout.show(content,SECOND_PANEL);
        }
    }); 
}