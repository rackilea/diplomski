public static int Bik (int n, int sum) {
    // You get the value of the last digit and sum it to your total
    sum += n%10;
    // This validation is to know if there is only 1 digit left  
    if (n>9) 
        // The required recursion
        return Bik(n/10, sum); 
    //In case the sum is higher than 9 the recursion is called again, otherwise it returns the sum
    return sum>9 ? Bik(sum, 0) : sum;
}

public static void main(String[] args) {
    System.out.println(Bik(1892, 0));
}