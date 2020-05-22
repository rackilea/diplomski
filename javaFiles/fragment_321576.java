double money = 123.45;

    int dollars = (int) Math.floor(money);
    double cents = money - dollars;
    int centsAsInt = (int) (100 * cents);

    System.out.println("dollars: " + dollars);
    System.out.println("cents: " + cents);
    System.out.println("centsAsInt: " + centsAsInt);