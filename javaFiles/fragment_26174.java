public DecreasingCounter(int valueAtStart) {
    //store the initial value based on the arg passed in
    this.initialValue = valueAtStart; 

    //go ahead and do whatever we do to reset our counter to the 
    //initial value (avoids duplicating code)
    this.setInitial(); 
}