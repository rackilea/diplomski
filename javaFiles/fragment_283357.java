private CardLayout cardLayout = new CardLayout(10, 10); // hgap and vgap args
private JPanel cardPanel = new JPanel(cardLayout);

JPanel panel1 = new JPanel(); // holds first player
JPanel panel2 = new JPanel(); // holds second player

cardPanel.add(panel1);
cardPanel.add(panel2);

nextButton.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
        cardLayout.next(cardPanel);
    }
});