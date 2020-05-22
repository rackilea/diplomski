private Action newGameAction = new AbstractAction("New Game") {
    @Override
    public void actionPerformed(ActionEvent e) {          
        this.core. // compiling error here: 'core' is not a member of the anonymous inner class
    }
};