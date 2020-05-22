// Calculates the difference between the two saved clicks
public void calculateTimeBetweenClicks() {
    if (buttonPressed == 1) {
        time1 = counter[0];
    } else {
        time1 = counter[0];
        time2 = counter[1];
        //Reset here ready for next 2 clicks...
        counter[0]=0;
        counter[1]=0;
        buttonPressed = 0;
    }
    time3 = time2 - time1;
}