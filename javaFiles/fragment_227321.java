public void actionPerformed(ActionEvent e) {

  new Thread(new Runnable {
    public void run() {
      ...
      // do some 'heavy lifting' here ...

      SwingUtilities.invokeLater(new Runnable() {
        public void run() {
          server.setupUI();
        }  
      )
      ...
      // or do some 'heavy lifting' here
    }); 
  }
}