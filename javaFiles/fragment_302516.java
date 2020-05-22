Scanner sc = new Scanner(System.in);

    System.out.println("Height?");
    while (!sc.hasNextInt()) {
        System.out.println("int, please!");
        sc.next();
    }
    final int N = sc.nextInt();

    String[] arr = new String[N];
    for (int L = 1; L <= N; L++) {
        String s;
        do {
            System.out.println("Length " + L + ", please!");
            s = sc.next();
        } while (s.length() != L);
        arr[L - 1] = s;
    }

    for (String s : arr) {
        System.out.println(s);
    }