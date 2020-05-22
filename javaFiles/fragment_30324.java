public void setSeparator(char sep) {
    //Name data = new Name();    //remove implicit nameObjsCount++
    boolean result = this.validSeparator(sep); //see below
    if (result == true) {
        this.sep = sep;
    }
}


public boolean equals(Name input) {
    // Name equation = new Name();    //remove implicit nameObjsCount++
    // equation.first = this.first;   //see below
    // equation.middle = this.middle;
    // equation.last = this.last;
    boolean firstTest = (this.first).equals(input.first);
    boolean middleTest = (this.middle).equals(input.middle);
    boolean lastTest = (this.last).equals(input.last);
    if (firstTest && middleTest && lastTest) {
        return true;
    }
    else {
        return false;
    }

}