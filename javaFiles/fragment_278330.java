public class Node {
    ...
    public void goNorth() { ... }
    public void goSouth() { ... }
    public void goEast() { ... }
    public void goWest() { ... }

    interface MoveAction {
        void move();
    }

    private MoveAction[] moveActions = new MoveAction[] {
        new MoveAction() { public void move() { goNorth(); } },
        new MoveAction() { public void move() { goSouth(); } },
        new MoveAction() { public void move() { goEast(); } },
        new MoveAction() { public void move() { goWest(); } },
    };

    public void move(int index) {
        moveActions[index].move();
    }
}