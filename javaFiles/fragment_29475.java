boolean solve(int[] digits, int sum) {
    return solve(digits, sum, 1, 0, 0);
}

boolean solve(int[] digits, int sum, int signum, int part, int index) {
    if (index >= digits.length) {
        return signum * part == sum;
    }
    // Before the digit at index do either nothing, +, or -
    return solve(digits, sum, signum, part * 10 + digits[index], index + 1)
            || solve(digits, sum - signum * part, 1, 0, index + 1)
            || solve(digits, sum - signum * part, -1, 0, index + 1);
}