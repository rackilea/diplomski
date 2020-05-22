// public function visible to the world
public static long factorial(int n) {   
    return factorial(5, 0);
} 

// helper function that takes in the current depth of 
// the recursion
private static long factorial(int n, int depth) {
    String spaces = repeat(' ', depth);
    System.out.print(spaces);
    System.out.println("factorial("+n+")");
    if (n <= 1) { // factorial(0) = factorial(1) = 1
        System.out.println(spaces + " return 1");
        return 1; 
    }

    long fac = factorial(n-1, depth + 1);
    System.out.print(spaces);
    System.out.printf("return %d * %d = %d%n", n, fac, n * fac);
    return n * fac;      
}

// helper function to create a String by repeating
// char c, n times.
private static String repeat(char c, int times) {
    char[] sequence = new char[times];
    Arrays.fill(sequence, c);
    return new String(sequence);
}