Scanner input = new Scanner(System.in);

System.out.print("n = ");
int n = input.nextInt();
double sum = 0;

for(int i = 1; i <= n; i++) {
    sum += 2 * Math.pow(i, 2) / Math.pow(2, i);
}

System.out.println(sum);