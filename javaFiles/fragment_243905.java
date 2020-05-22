for (Player p : Arrays.asList(p1, p2)) {
  int det = (p == p1) ? 2 * n - 1 : 2 * n;
  if (turn == det && stoneNum > 0) {
    System.out.println(p.getName() + "'s turn - remove how many? : ");
    remove = sc.nextInt();
    s.setStone(remove);
    stoneNum = stoneNum - s.removeStone();
    showStones();
    if (stoneNum <= 0) {
      turn = (p == p1) ? 1 : 2;
      break;
    }
  }
}