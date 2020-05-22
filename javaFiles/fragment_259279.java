public class Recursividad {

    public static int Func(int n)
    {
        System.out.println(n);
        if (n == 1)
            return n;
        else 
            return Func(n-2);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int x = Func(n);
    }
}