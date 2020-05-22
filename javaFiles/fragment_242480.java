BoardState goal = BoardState.goal();
System.out.println("goal");
goal.print();
BoardState start = BoardState.random();
System.out.println("start");
start.print();
start.setGoal(goal);
start.setDistFromGoal(start.distance(goal));
start.setPriority(start.distFromGoal + start.depth);
PriorityQueue<BoardState> open = new PriorityQueue<>(Comparator.comparing(b -> b.getPriority()));
open.offer(start);
Set<BoardState> set = new HashSet<>();
set.add(start);
int round = 0;
while (!open.isEmpty()) {
    BoardState cur = open.poll();
    round++;
    if (cur.equals(goal)) {
        System.out.println("goal found after " + round + " rounds");
        System.out.println("printing boards in reverse order");
        do {
            cur.print();
        } while (null != (cur = cur.getPrev()));
        break;
    }
    for (BoardState move : cur.moves()) {
        if (!set.contains(move)) {
            set.add(move);
            open.offer(move);
        }
    }
}