for(int i = 0; i <= coins.size()-1; i++) {
    int k = i+1;

    System.out.print("Pile " + k + ": ");
    for(int j = 0; j < coins.get(i); j++) {
        System.out.print("*");
    }

    System.out.println();
}