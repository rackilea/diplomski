//Minimize the JFrame
this.setExtendedState(JFrame.ICONIFIED);
//Now I use Robot to get a screenshot using another method
//not reported for simplicity
myMethodToGetScreenshot();
//Restore the JFrame
this.setExtendedState(JFrame.NORMAL);