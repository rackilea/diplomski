public void findVariables(int[] constants, int sum, 
                              int[] variables, int n, int result) {
        if (n == constants.length) { //your end condition for the recursion
            if (result == sum) {
                printArrayAsList(variables);
            }
        } else if (result <= sum){ //keep going
            for (int i = 0; result + constants[n]*i <= sum; i++) {
                variables[n] = i;
                findVariables(constants, sum, variables, n+1, result+constants[n]*i);
            }
        }
    }