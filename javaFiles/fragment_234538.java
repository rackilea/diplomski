Scanner input = new Scanner(System.in);
final int n = input.nextInt(), k = input.nextInt();

InputStreamReader in = new InputStreamReader(System.in);

System.out.println(
        IntStream.generate(()->Integer.parseInt(in.readLine()))
                 .limit(n)
                 .parallel()
                 .filter(a->a%k==0)
                 .count());