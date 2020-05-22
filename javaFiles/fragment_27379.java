public static void main(String[] args) throws java.lang.Exception {
    int n, k;


    BufferedReader input = new BufferedReader( new InputStreamReader(System.in));
    String str[]= input.readLine().split(" ");
    n = Integer.parseInt(str[0]);
    k = Integer.parseInt(str[1]);
    int total = 0;
    int values[] = new int[n];
    for (int i = 0; i < n; i++) {
        values[i]=Integer.parseInt(input.readLine());
        if ((values[i] % k) == 0) {
            total++;
        }
    }
    System.out.println(total);
}