for (int i = startValue; i<=endValue; i++){
    System.out.println(i);
    //above was just to demonstrate how console prints all ints but lblOutput does not.
    this.lblOutput.setText(this.lblOutput.getText() + " " + String.valueOf(i));

}