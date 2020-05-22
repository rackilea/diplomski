/**
 * findChange returns true if it is possible to make *change* cents of change
 *     using the coins in coinTypes. It adds the solution to answerCoins.
 *     If it's impossible to make this amount of change, then it returns false.
 */
boolean findChange(int change, List<Integer> coinTypes, List<Integer> answerCoins) {
    if change is exactly 0: then we're done making change for 0 cents! return true
    if change is negative: we cannot make change for negative cents; return false
    otherwise, for each coin in coinTypes {
        // we solve the subproblem of finding change for (change - coin) cents
        // using the recursive call.
        if we can findChange(change - coin, coinTypes, answerCoins) {
            // then we have a solution to the subproblem of
            // making (change - coins) cents of change, so:
            - we add coin to answerCoins, the list of coins that we have used
            - we return true // because this is a solution for the original problem
        }
    }
    //if we get to the next line, then we can't find change for any of our subproblems
    return false
}