public void initKeyBinding() {

    mapKeys = new HashMap<>();
    mapKeys.put(MOVE_UP, false);
    mapKeys.put(MOVE_DOWN, false);
    mapKeys.put(MOVE_LEFT, false);
    mapKeys.put(MOVE_RIGHT, false);
    mapKeys.put(START_GAME, false);
    mapKeys.put(PAUSE_GAME, false);
    mapKeys.put(ESCAPE, false);

    addKeyBinding(KeyEvent.VK_UP, MOVE_UP);
    addKeyBinding(KeyEvent.VK_DOWN, MOVE_DOWN);
    addKeyBinding(KeyEvent.VK_LEFT, MOVE_LEFT);
    addKeyBinding(KeyEvent.VK_RIGHT, MOVE_RIGHT);
    addKeyBinding(KeyEvent.VK_S, START_GAME);
    addKeyBinding(KeyEvent.VK_ESCAPE, ESCAPE);

}

private void addKeyBinding(int keyCode, String name) {
    // keyRelease - true if the KeyStroke should represent a key release; false otherwise
    // keyCode - an int specifying the numeric code for a keyboard key

    InputMap inputMap = getInputMap(WHEN_IN_FOCUSED_WINDOW);
    ActionMap actionMap = getActionMap();

    inputMap.put(KeyStroke.getKeyStroke(keyCode, 0, true), "pressed" + name);
    inputMap.put(KeyStroke.getKeyStroke(keyCode, 0, false), "released" + name);

    actionMap.put("pressed" + name, new KeyAction(name, true));
    actionMap.put("released" + name, new KeyAction(name, false));
}


public class KeyAction extends AbstractAction {
    private String name;
    private boolean state;

    public KeyAction(String name, boolean state) {
        this.name = name;
        this.state = state;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(name);
        System.out.println(state);
        mapKeys.put(name, state);

        if (inGame) {
            switch (name) {
                case MOVE_UP:
                    req_dx = 0;
                    req_dy = -1;
                    break;
                case MOVE_DOWN:
                    req_dx = 0;
                    req_dy = 1;
                    break;
                case MOVE_RIGHT:
                    req_dx = 1;
                    req_dy = 0;
                    break;
                case MOVE_LEFT:
                    req_dx = -1;
                    req_dy = 0;
                    break;
                case ESCAPE:
                    if (timer.isRunning()) {
                        inGame = false;
                    }
                    break;
            }
        } else {
            if (mapKeys.put(START_GAME, false)) {
                inGame = true;
                initGame();
            }
        }
    }
}

@Override
public void actionPerformed(ActionEvent e) {

    repaint();
}