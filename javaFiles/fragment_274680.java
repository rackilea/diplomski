public void checkTwopairs() {
    boolean firstPair = false;              // New local variable.
    for (int i = 1; i <= 6; i++) {
        int a = checknumber(i);
        if (a == 2) {
          //if (twopair == true && a == 2)  <--- This second clause is unnecessary as we can only get here if a == 2
            if (firstPair == true) {
                twopair = true;
                return;                     //This returns the method, so twopair cannot be set to false if two pairs are found
            } else {
                firstPair = true;
            }
        }
    }
    //Checked all dice, less than two pairs were found. 
    twopair = false;
}