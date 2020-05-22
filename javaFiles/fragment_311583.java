public static boolean isPrime(int x)
{   
    if(x > 2) {
        if(x%2 == 0) {
            return false;
        } else {
            int sqrt = (int)(Math.sqrt(x));
            for(int i=3;i<=sqrt;i+=2) {
                if(x%i == 0) {
                     return false;
                }
            }
        }
        return true;
    } else if(x==2) {
        return true;
    } else { //1, 0, and negatives
        return false;
    }
}