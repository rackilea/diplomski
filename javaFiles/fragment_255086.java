final Timer timer = ...;
timer.start();
...
JButton button = ... ;
button.addActionListener( new ActionListener(){
  @Override
  public void actionPerformed( ActionEvent e ){
    timer.stop();
  }
});