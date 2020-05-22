for (int i = 1; i <= 4; i++) {
    System.out.print(i);//<<----------Print the index i
    for (int j = 0; j < i; j++) {
        System.out.print(i == 1 ? "**" : "*");//check if i == 1 then print 2 stars else 1
    }
    System.out.println("");
}