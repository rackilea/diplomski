Scanner scan = new Scanner(System.in);
        int res;

        while (scan.hasNext()) {
            res = scan.nextInt();
            if (res != 42) {
                System.out.println(res);
            } else {
                System.exit(0);
            }
        }