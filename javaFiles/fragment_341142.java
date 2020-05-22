public class PrimeFactors {
    int count;
    static int input;
    int num;
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Integer> factors = new ArrayList();

    public static void main(String[] args) {
        PrimeFactors pfo = new PrimeFactors();
        input = sc.nextInt();
        pfo.primeFactor();
        for(int element : factors){
            System.out.println(element);
        }
    }

    public void primeFactor(){
        if (input > 1) {

            for(int i = input; i >= 1; i--){
                if(isPrime(i)){
                    if (divide(i)) {
                        System.out.println("Adding a new int...");

                        factors.add(i);
                        input = input / i;
                        primeFactor();
                    }
                }
            }

        }
    }

    public boolean isPrime(int number){
        int count = 0;
        for(int i = 2; i < number; i++){
            if(number % i == 0){
                count++;
            }
        }
        return (count == 0);
    }

    public boolean divide(int number){
        return (input % number == 0);
    } 
}