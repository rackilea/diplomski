Scanner input = new Scanner(System.in);
    BigDecimal bigDecimal = new BigDecimal(0);
    while (input.hasNext()) {
        String i = input.next();
        if (i.equals("0"))
            break;
        bigDecimal = bigDecimal.add(new BigDecimal(i));
    }
    input.close();
    System.out.println("BigDecimal " + bigDecimal);
    System.out.println("Long " + bigDecimal.longValue()); // caution - narrowing