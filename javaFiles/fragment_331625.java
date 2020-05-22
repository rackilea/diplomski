//Main Panel to contain everything
        JPanel main = new JPanel();
        main.setLayout(new BoxLayout(main,BoxLayout.Y_AXIS));

        JLabel welcome=new JLabel("Welcome to Match Card Game ☺");
        //Setting prefered Font-Size
        welcome.setFont(new Font(welcome.getName(), Font.PLAIN, 24));


        JButton start=new JButton("Start Game");

        //Change button size and apparence
        start.setPreferredSize(new Dimension(150,50));
        start.setContentAreaFilled(false);


        //Add two sub-panels for advanced positioning
        JPanel welcome_p=new JPanel(new FlowLayout(1,0,150));
        JPanel button_p=new JPanel();

        //Set welcomepanel size to lower space to Button
        welcome_p.setPreferredSize(new Dimension(300,150));
        welcome_p.add(welcome);

        button_p.add(start);
        main.add(welcome_p);

        main.add(button_p);

        add(main);
        setSize(800, 600);
        setTitle("Match Card Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);