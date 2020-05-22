public static void main(String[] args) {
        String str[] = {"Enter your name", "Enter your age", "Enter your salary"};
        Scanner sc = new Scanner(System.in);
        int[] i = new int[2];
        String[] s = new String[2];
        int[] y = new int[2];
        for (int x = 0; x < 2; x++) {
            System.out.println(str[0]);
            s[x] = sc.nextLine();
            System.out.println(s[x]);

            System.out.println(str[1]);
            i[x] = sc.nextInt();
            System.out.println(i[x]);

            System.out.println(str[2]);
            y[x] = sc.nextInt();
            System.out.println(y[x]);
            sc.nextLine();// add this line to skip "\n" Enter key
        }
    }