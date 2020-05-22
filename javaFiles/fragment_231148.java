JFrame frame=new JFrame();//create frame

//so when we exit or dispose of Jframe it doesnt exit the entire app
frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

...

frame.pack();
frame.setVisible(true);