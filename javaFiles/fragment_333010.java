GUI frame = new GUI();
// Better idea to do this before you make the frame visible
// as it can change the frame borders and cause some issues
frame.setResizable(false); 
frame.setVisible(true);

Thread thread = new Thread(frame);
thread.start();