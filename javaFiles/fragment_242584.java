public static boolean PrimeRec(int n,int d){
    System.out.println("PrimeRec called with n=" + n + " d=" + d);
    if(d==1) {
        System.out.println("d=1, returning true");
        return true;
    }
    else if(n%d==0) {
        System.out.println("d divides n, returning false");
        return false;
    }
    else { 
        System.out.println("calling PrimeRec recursively");
        boolean answer = PrimeRec(n,d-1);
        System.out.println("back from recursive PrimeRec, returning " + answer);
        return answer;
    }
}