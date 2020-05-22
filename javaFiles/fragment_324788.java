public boolean isMoveLegal(int moveFrom, int moveTo){
    ArrayList<Integer> toPeg = lists.get(moveTo);
    if (toPeg.isEmpty()) return true; // You can move anything on an empty peg
    int y = toPeg.get(0).intValue();
    ArrayList<Integer> fromPeg = lists.get(moveFrom);
    if (fromPeg.isEmpty()) return false; // No disks on the "from" peg
    int x = fromPeg.get(0).intValue();
    if(x>y){
       System.out.println("illegal move");
       return false;
    }
    return true;
}