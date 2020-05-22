private JLabel searchedstock;

public void gamegui() {
    /*...*/
    final JLabel searchedstock = new JLabel(stockvalue);
    JButton search = new JButton("Search");
    search.addActionListener(new ActionListener() {

        public void actionPerformed(ActionEvent e){

            stockvalue = Double.toString(getstocks(symbolsearch.getText()));
            searchedstock.setText(NumberFormat.getNumberInstance().format(stockValue));
        }
    });
    gamepanel.add(search, c);
    c.gridx = 0;
    c.gridy = 5;
    gamepanel.add(new JPanel(), c);
    c.gridx = 0;
    c.gridy = 6;
    c.gridwidth = 2;
    searchedstock = new JLabel(stockvalue);
    gamepanel.add(searchedstock, c);
    add(gamepanel);
}