public double computeBalance(double startingBalance, Check[] register) {

    // let's start off from the starting balance
    double total = startingBalance;

    // go over all elements starting from 0
    for (int i = 0; i < check.length; i++) {

        // make sure you did not encounter null element
        if (register[i] != null) {

            // increase the total by the amount of the Check
            total += register[i].getAmount();
        }
    }

    // and finally return the resulting value
    return total;
}