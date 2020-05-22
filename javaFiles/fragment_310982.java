public MainWindow() {
    initComponents();

    //initialize the timer and the counter
    timer = new Timer(DELAY, this);
    timer.start();
    myCounter = 0;
}

//method needed for the timer, since this class implements ActionListener
//this method will get called however often the DELAY is set for
@Override
public void actionPerformed(ActionEvent e){
    myCounter++;
    labelOutput.setText(Integer.toString(myCounter));
}//end of method