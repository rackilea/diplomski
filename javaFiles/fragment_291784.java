Scanner sc = new Scanner(System.in);

for (int i = o; i < 100; i++){
    int upperLimit = sc.nextInt();
    for (int w = 0; w < upperLimit; w++){
        sum = sum + i;
    }
    System.out.println("Sum is " + sum);
}