public class uhs {
    public static void main(String[] args) {
        int z = Integer.parseInt(args[0]);
        int q = Integer.parseInt(args[1]);
        System.out.println(hornerUmkehrungRekursiv(z, q));
    }

    static int hornerUmkehrungRekursiv(int z, int q) {
        if (z / q != 0) {
            System.out.print(hornerUmkehrungRekursiv(z / q, q));
        }
        return z % q;
    }
}