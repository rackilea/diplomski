public class Handler {
    //...
    private Set<InputAction> inputActions = new HashSet<InputAction>();

    public void render(Graphics g) {
        for (int i = 0; i < object.size(); i++) {
            GameObject tempObject = object.get(i);

            tempObject.update();
            tempObject.render(g);
        }
    }

    public boolean is(InputAction action) {
        return inputActions.contains(action);
    }

    public void set(InputAction action) {
        inputActions.add(action);
    }

    public void remove(InputAction action) {
        inputActions.remove(action);
    }
    //...

}