public void actionPerformed(ActionEvent ae)
{
    Object buttonClicked = ae.getSource();
    if(buttonClicked.equals(theView.getStartButton()))
    {
      theModel.setGo(true); //make it continue if it's just stopped
      Thread t = new Thread(new Runnable() { public void run() {theModel.go();}}); //This separate thread will start the new go...
      t.start(); //...when you start the thread! go!
    }
    else if(buttonClicked.equals(theView.getCancelButton()))
    {
        theModel.setGo(false);
    }
}