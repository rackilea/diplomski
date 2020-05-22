int m, n, i, z = 0;
    int x = 3;
    boolean div;

    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the range for shipment numbers :");
    m = sc.nextInt();
    n = sc.nextInt();
    System.out.println("Possible shipment numbers :");
    for (i = m; i <= n; i++) {
        z = i;
        div = true;
        while (z > 0) {
            if (z % 10 % x != 0) {
                div = false;
                break;
            }
            z /= 10;
        }
        if (div) System.out.println(i);
    }