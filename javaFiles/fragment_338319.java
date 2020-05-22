height = (height==0?30:height);
    for(int i=1; i<=100; i++) {
        if (i % height== 0) {
            System.out.println("Press enter to continue output...");
            System.in.read();
        }
        System.out.println(i);
    }