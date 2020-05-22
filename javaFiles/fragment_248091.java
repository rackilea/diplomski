int highest = Math.max(randInt1, Math.max(randInt2, randInt3));
for(int i = highest; i > 0; i--){
    printColumn(width1, randInt1, i);
    System.out.print(" ");

    printColumn(width2, randInt2, i);
    System.out.print(" ");

    printColumn(width3, randInt3, i);
    System.out.println();
}