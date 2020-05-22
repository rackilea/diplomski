// can also pass in an icon to this constructor as a 2nd parameter
  Action myAction = new AbstractAction("Some Text") {
     {
        // set properties here including mnemmonic
        putValue(MNEMONIC_KEY, KeyEvent.VK_S);
     }

     @Override
     public void actionPerformed(ActionEvent e) {
        // action initiated code goes here
     }
  };