for(i = 1; i <=height; i++) {
    for(j = 1; j <= width; j++) {
        if(i == 1 || i == height || j == 1 || j == width)
            System.out.print(x);
        else
            System.out.print(" ");
    }
    System.out.println();
}