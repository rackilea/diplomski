while (condition) {

  top:

  System.out.print('\u000C');
  System.out.println("  A  ,  B  ,  C  ");
  System.out.println("| " +slot[0]+ "  |  " +slot [1]+  "  |  " +slot[2]+ "  |");
  System.out.println("| " +slot[3]+ "  |  " +slot [4]+  "  |  " +slot[5]+ "  |");
  System.out.println("| " +slot[6]+ "  |  " +slot [7]+  "  |  " +slot[8]+ "  |");

  middle:

  System.out.println("What number do you want to move <1, 2, 3>: ");
  disk = (input.readLine());
  System.out.println("What tower do you want to put <A, B, C>: ");
  tower = (input.readLine());

  // First Move 
  if(disk.equals("1") && tower.equals("b")) {
    slot[0] = slot[8];
    // use continue skip the rest code
    // continue top;
    // if you want goto top, continue and continue top is same
    continue;
    // if you want goto middle, you can use the label
    // continue middle;
  }

  // some other code
}