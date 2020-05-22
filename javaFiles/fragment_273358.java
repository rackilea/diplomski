save(50, "C:\\test.dat");
    save("A String", "C:\\test2.dat");

    Integer t1 = load("C:\\test.dat");
    System.out.println(t1);

    String t2 = load("C:\\test2.dat");
    System.out.println(t2);