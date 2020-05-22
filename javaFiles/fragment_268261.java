String[] players = new String[]{"Tom", "Dick", "Harry", "Matthew", "Johh"};
System.out.printf("%-10s%6s%6s%6s%6s","Player", "Game1 ", "Game2 ", "Game3 ", "Game4 ");
System.out.println();
Random r = new Random();
for (String player : players){
    System.out.printf("%-10s%3d%6d%6d%6d",player, r.nextInt(10), r.nextInt(10), r.nextInt(10), r.nextInt(10));
    System.out.println();
}