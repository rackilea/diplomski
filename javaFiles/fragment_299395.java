import java.util.Scanner;


class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n, suma, mayoria;
        int casos = s.nextInt();
        int cont = 0;
        int ganador = 0;
        float num = 0;
        while (cont != casos) {
            n = s.nextInt();
            int votos[] = new int[n];
            for (int i = 0; i < n; i++) {
                votos[i] = s.nextInt();
            }

            ganador = findMaximum(votos);

            if (getMaximumCount(votos, votos[ganador]) > 1) {
                System.out.println("no winner");
            } else {
                suma = sumOf(votos);
                if (votos[ganador] * 2 > suma) {
                    System.out.println("majority winner " + (ganador + 1));
                } else {
                    System.out.println("minority winner " + (ganador + 1));
                }
            }
            cont++;
            ganador = 0;
        }
    }

    private static int sumOf(int[] arreglo) {
        int sum = 0;
        for (int x : arreglo) {
            sum += x;
        }
        return sum;
    }

    private static int getMaximumCount(int[] arreglo, int maximum) {
        // Check if there are more than one items have the maximum value
        int count = 0;
        for (int x : arreglo) {
            if (x == maximum) {
                count++;
            }
        }
        return count;
    }

    private static int findMaximum(int[] arreglo) {
        int x = 0, pos = 0;
        for (int i = 0; i < arreglo.length; i++) {
            if (x < arreglo[i]) {
                x = arreglo[i];
                pos = i;
            }
        }
        return pos;
    }
}