private int counter=0;

public void onClick(View v) {
    int i=counter;
    //everything continues, just remove the for loop
    angle.setText("Beta =" + ang);
    counter++;
    if(counter==12) counter=0;//your arrays are fixed, so we are turning back
}