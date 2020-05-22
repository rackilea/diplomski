public static int[] computePrefixFunction(String input) 
    {
        int[] pi = new int[input.length()];
        int k = 0;
        for (int q = 1; q < input.length(); q++) {
            char target = input.charAt(q);
        while (k > 0 && input.charAt(k) != target) k = pi[k - 1];
        if (input.charAt(k) == target) k++;
        pi[q] = k;
    }
    return pi;
}

   public static Queue<Integer> KMPMatcher(String T, String P) 
{
    int n = T.length();
    int m = P.length();
    int[] pi = computePrefixFunction(P);
    int q = 0;
    Queue<Integer> Q = new LinkedList<>();
    for(int i = 0; i < n; i++) 
    {
        while(q > 0 && P.charAt(q) != T.charAt(i)) 
            q = pi[q-1];
        if(P.charAt(q) == T.charAt(i)) 
            q++;
        {
            Q.add(i-q+1); // Change it.
            q = pi[q-1];
        }     
    }
    return Q;
}

public static void main(String[] args) {
    System.out.println(KMPMatcher("bdacabdacb","bda"));
}