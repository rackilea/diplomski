Scanner sc = new Scanner("aaaa 1.1 bbb\n3");
    sc.useLocale(Locale.US);
    while (sc.hasNext()) {
        if (sc.hasNextDouble()) {
            System.out.println(sc.nextDouble());
        } else {
            sc.next();
        }
    }