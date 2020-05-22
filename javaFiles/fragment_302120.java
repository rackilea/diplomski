FlexibleSavingsAccount1 saver1 = new FlexibleSavingsAccount1(10002, 2000, .012);
    CDSavingsAccount1 saver2 = new CDSavingsAccount1(10003, 3000, .04);                                                                     
    System.out.println("Month\tAccount #   Balance\tAccount #   Balance");
    System.out.println("-----\t---------   -------\t---------   -------");
    System.out.print("    0");
    print(saver1);
    print(saver2);
    System.out.println();
    for (int i = 1; i <= 12; i++) {
        System.out.printf("%5d", i);
        printInt(saver1);
        printInt(saver2);
        System.out.println();
    }
    System.out.printf("Final balance of both accounts combined: %.2f\n",
            (saver1.getBalance() + saver2.getBalance()));
}