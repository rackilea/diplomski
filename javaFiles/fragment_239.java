//number of players combo box
//the combo box still needs to be final here
final JComboBox players = new JComboBox();
contentPane.add(players, BorderLayout.SOUTH);
players.addItem("1 Player");
//your combo box still needs to be final
final JComboBox players = new JComboBox();
contentPane.add(players, BorderLayout.SOUTH);
players.addItem("2 Players");
players.addItem("3 Players");
players.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        int myIndex = players.getSelectedIndex();
        if (myIndex == 0 || myIndex == 1) {
            makeFrame();
        }
        else {
            //do something else
        }
    }
});
//end of combo box