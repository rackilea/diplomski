public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int array[] = new int[10];
    for (int i = 0; i < 10; i++)
        array[i] = 10000 + scan.nextInt();       
    System.out.println(Arrays.toString(array));
}