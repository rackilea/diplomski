Scanner scanner = new Scanner(System.in);
System.out.println("Enter the number of members of array:");
int k = scanner.nextInt();

int[] pos = new int[k];
int[] neg = new int[k];

for (int i = 0; i < k; i++) {
    System.out.println("Enter a number:");
    int numberUser = scanner.nextInt();
    if (numberUser > 0) {
        pos[i] = numberUser;
    } else {
        neg[i] = numberUser;
    }
}
System.out.println(Arrays.toString(pos));
System.out.println(Arrays.toString(neg));