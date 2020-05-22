p.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {

        System.out.println("Welcome to Guess the number Game");
        System.out.println("You have 3 chances to guess a number between 0 and 10 excluding 10");

        ne.remove(p);

        // ne.removeAll();
        ne.revalidate();
        ne.repaint();
        cam();
    }

});

public void cam() {

    gamer2 game = new gamer2();
    game.generatenum();
}