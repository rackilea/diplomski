for(int i = 0; i < 3; i++) {
    try {
        System.out.println("Test " + count);
        int a = 10 / i;
        System.out.println("Success !");
        break;

    } catch (Exception e) {
        System.out.println("ERROR:\t" + e);
    }
 }
 System.out.println("Finish");