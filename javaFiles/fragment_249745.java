public class Display extends JPanel{    
    public Display(){
        // !! menuPanel = new JPanel(new GridBagLayout());
        GridBagConstraints con = new GridBagConstraints();

        mainMenuImageP = new JPanel();
        mainMenuImageP.setBackground(Color.BLACK);
        con.fill = GridBagConstraints.BOTH;
        con.gridy = 0;
        con.gridx = 0;
        con.gridwidth = 2;
        con.weightx = 0.5;
        con.weighty = 0.5;
        con.anchor = GridBagConstraints.CENTER;
        con.ipadx = 400;
        con.ipady = 300;
        con.insets = new Insets(0,20,0,20);
        // !! menuPanel.add(mainMenuImageP, con);
        add(mainMenuImageP, con); // !!

        newGameB = new JButton("New Game");
        con.fill = GridBagConstraints.HORIZONTAL;
        con.gridy = 1;
        con.gridx = 0;
        con.gridwidth = 1;
        con.weightx = 0.5;
        con.weighty = 0.5;
        con.anchor = GridBagConstraints.CENTER;
        con.ipadx = 0;
        con.ipady = 0;
        con.insets = new Insets(10,10,10,10);
        // !! menuPanel.add(newGameB, con);
        add(newGameB, con); // !!

        loadGameB = new JButton("Load Game");
        con.fill = GridBagConstraints.HORIZONTAL;
        con.gridy = 1;
        con.gridx = 1;
        con.gridwidth = 1;
        con.weightx = 0.5;
        con.weighty = 0.5;
        con.anchor = GridBagConstraints.CENTER;
        con.ipadx = 0;
        con.ipady = 0;
        con.insets = new Insets(10,10,10,10);
        // !! menuPanel.add(loadGameB, con);
        add(loadGameB, con); // !!

        // !! add(menuPanel);
    }

}