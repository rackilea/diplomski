//number of players combo box
//notice that you have to declare players
//as final. If it is a member of the class,
//you can declare it final in the field
//declaration and initialize it in the
//constructor, or if local, just leave it
//as it is here. Unless using Java 8, then it
//doesn't need to be declared final
final JComboBox players = new JComboBox();
contentPane.add(players, BorderLayout.SOUTH);
players.addItem("1 Player");
//your combo box still needs to be final
final JComboBox players = new JComboBox();
contentPane.add(players, BorderLayout.SOUTH);
players.addItem("1 Player");
players.addItem("2 Players");
players.addItem("3 Players");
players.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        String selectedValue = String.valueOf(players.getSelectedItem());
        if (selectedValue != null && (selectedValue.equals("1 Player") || selectedValue.equals("2 Players"))) {
            makeFrame();
        }
        else {
            //do something else
        }
    }
});
//end of combo box