int num[] = new int[6];
System.out.println("Input 6 numbers: ");
for (int i = 0; i < 6; i++) {
    num[i] = Integer.parseInt(br.readLine());
}

Arrays.sort(num);

System.out.println("sorted array");
for (int i = 5; i >= 0; --i) {
    System.out.println(num[i]);
}