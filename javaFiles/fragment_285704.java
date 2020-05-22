Scanner sc =new Scanner(System.in);
    System.out.println("enter a number");
    int a =sc.nextInt();
    long[] b = new long[a];
    for (int i = 0; i < a; i++) {
         b[i]=sc.nextLong();
    }       
    long[] tem = new long[a];
    System.arraycopy(b, 0, tem, 0, a);
    Arrays.sort(b);

    for (int i = 0; i < a; i++) {
          int res = java.util.Arrays.binarySearch(b, tem[i]);
         System.out.print(res + 1 + " ");
    }