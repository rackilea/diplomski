radioPanel rdpnl = new radioPanel();
rdpnl.getUnlock().addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e) {
        tableModel.setEditable(true);
    }
});
rdpnl.getLock().addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e) {
        tableModel.setEditable(false);
    }
});

getContentPane().add(rdpnl, BorderLayout.NORTH);