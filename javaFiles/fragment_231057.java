public class NewGame extends JPanel implements ActionListener {

    private final String[] premierLeagueClubs = {"Arsenal", "Bournemouth", "Burnley", "Chelsea", "Crystal Palace",
                                                                                             "Everton", "Hull City", "Leicester City", "Liverpool", "Manchester United", "Manchester City", "Middlesborough",
                                                                                             "Southampton", "Stoke City", "Sunderland", "Swansea City", "Tottenham Hotspur", "Watford", "West Brom", "West Ham"};
    private final JRadioButton[] rb = new JRadioButton[20];
    private final JButton b, quit;
    String teamName;
    JLabel label1;

    ButtonGroup bg = new ButtonGroup();

    public NewGame() {
        setBackground(Color.GREEN);

        label1 = new JLabel("Please choose a team");
        add(label1);

        for (int i = 0; i < premierLeagueClubs.length; i++) {
            rb[i] = new JRadioButton(premierLeagueClubs[i]);
            rb[i].setActionCommand(premierLeagueClubs[i]);
            bg.add(rb[i]);
            add(rb[i]);
        }

        b = new JButton("OK");
        b.addActionListener(this);
        add(b);

        quit = new JButton("Quit");
        quit.addActionListener(this);
        add(quit);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("You have selected " + bg.getSelection().getActionCommand());
    }

}