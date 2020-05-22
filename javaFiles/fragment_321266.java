public static StringBuilder getDivisors(int number) {
    StringBuilder numbersDivisor = new StringBuilder();
    int i = 0;
    for (i = 1; i < number; i++) {
        if (number % i == 0 && i != number && isPalindromic(i)) {
            numbersDivisor.append(i).append(',');
        }
    }
    if(0 < (i = numbersDivisor.length())) {
        numbersDivisor.deleteCharAt(i - 1);//remove that last comma
    }
    return numbersDivisor;
}