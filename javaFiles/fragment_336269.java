continueButton.addActionListener(new ActionListener() {

    @Override
    public void actionPerformed(ActionEvent e) {
        CardLayout cl = (CardLayout) (cards.getLayout());
        cl.show(cards, MAINMENU);
   }
});