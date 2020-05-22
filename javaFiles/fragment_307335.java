String[] arr = new String[10];
sc = new Scanner(System.in);

for(int x = 0; x < 10; x++) {
    arr[x] = sc.nextLine();
}
Collections.shuffle(Arrays.asList(arr));

System.out.println(Arrays.toString(arr));