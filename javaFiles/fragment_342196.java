static public class PressAction extends AbstractAction {

    private final Set<Direction> movement;
    private final Direction value;

    public PressAction(Set<Direction> movementState, Direction value) {
        this.movement = movementState;
        this.value = value;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        movement.add(value);
    }
}
static public class ReleaseAction extends AbstractAction {

    private final Set<Direction> movement;
    private final Direction value;

    public ReleaseAction(Set<Direction> movementState, Direction value) {
        this.movement = movementState;
        this.value = value;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        movement.remove(value);
    }
}