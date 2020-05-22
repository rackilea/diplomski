if(buttonKLick.getSource() == this.btnStart){
    btnStart.setEnabled(false);
    new Thread(new Runnable() {
      public void run() {
        try {
          Funktionen.fileFinder(Pfad); //The Function
        } catch (FileNotFoundException e) {
          e.printStackTrace();
        }
      }
    }).start();
}