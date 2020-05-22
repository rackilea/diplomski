class ButtonListener {
  public void addActionListener(ActionEvent e) throws InterruptedException {
     JButton source = (JButton) e.getSource();

     // ...

        while (paused = false) { // *******
           nextGen();
           Thread.sleep(1000);  // ******
        }
     }

     // ...

}