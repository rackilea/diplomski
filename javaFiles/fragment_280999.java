public static void main (String[] args) {
   Scanner scan = new Scanner(System.in);
   System.out.println("Please type 10 integers:");
   int[] num = new int[10];
   int[] reverse = new int[10];
   for (int a = 0; a < num.length; a++) {
       num[a] = scan.nextInt();
    }

if (num[0] == num[9] && num[1] == num[8] && num[2] == num[7] 
     && num[3] == num[6] && num[4] == num[5])
        System.out.println("The sequence is palindromic.");
 else 
    System.out.println("The sequence is not palindromic.");