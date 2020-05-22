final JButton jumpTo = new JButton("Jump To");
buttonPanel.add(jumpTo);
jumpTo.addActionListener( new ActionListener(){
    @Override
    public void actionPerformed(ActionEvent ae) {
        String[] names = {"1","2","3","4"};
        String s = (String)JOptionPane.showInputDialog(
            jumpTo,
            "Jump to card",
            "Navigate",
            JOptionPane.QUESTION_MESSAGE,
            null,
            names,
            names[0]);
        if (s!=null) {
            cl.show(cardPanel, s);
        }
    }
} );