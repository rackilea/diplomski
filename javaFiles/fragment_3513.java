Scanner sc = new Scanner(System.in);
String[] tokens = sc.nextLine().split(" ");
int[] result = new int[tokens.length];
int i = 0;
for (String token : tokens)
    result[i++] = Integer.parseInt(token);
// here you will have de desired array stored in the variable 'result'.