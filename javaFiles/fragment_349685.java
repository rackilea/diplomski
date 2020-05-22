public Virus(){
    jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    jf.setResizable(false);                               
    thegame.add(start);
    thegame.add(game);
    jf.add(thegame);        
    jf.pack();
    jf.setLocationRelativeTo(null);
    jf.setVisible(true);
}