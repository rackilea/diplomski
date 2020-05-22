Scanner in = new Scanner(System.in);
    while (true) {
        int n = Integer.parseInt(in.nextLine());
        if (n == -1) break;
        for (int i = 0; i < n; i++) {
            System.out.println("L:" + in.nextLine());
        }
    }