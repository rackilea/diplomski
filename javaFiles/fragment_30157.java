for (int i=0; i<=input; i++) {
    for(int j=input; j>=i; j--) {
        System.out.print(" ");
    }

    for (int k=1; k<=i*2-1; k++) {
        if (k%2 == 0)
            System.out.print("o");
        else
            System.out.print("x");
    }

    System.out.println();
}