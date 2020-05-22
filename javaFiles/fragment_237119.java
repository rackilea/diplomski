public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ArrayList<Long> woah = new ArrayList<Long>();
        long number = 600851475143L;
        for (long i = 1; i< Math.sqrt(number); i=i+1){
            long placeHolder = i - 1;

            if (number%i==0L && isPrime(i)){
                woah.add(i);
                System.out.println(i);
            }
        }
    }

    public static boolean isPrime(long num) {
        if (num % 2 == 0 && num != 2) return false;
        for (int i = 3; i * i <= num; i += 2)
            if (num % i == 0) return false;
        return true;
    }

}