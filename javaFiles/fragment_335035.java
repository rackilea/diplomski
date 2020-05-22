Scanner in = new Scanner(System.in);

int cont = 0;
int num = 1;
int soma;
System.out.println("Quantos números perfeitos?");
int n = in.nextInt();

while (cont < n) {
    soma = 0; //Don't forget this line

    for (int i = 1; i <= num / 2; i++) {
        if (num % i == 0) {
            soma = soma + i;
        }
    }

    if (num == soma) {
        System.out.println(num + " é perfeito.");
        cont++;
    }

    num++;
}