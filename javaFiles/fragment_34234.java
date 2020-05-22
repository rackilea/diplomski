import java.awt.event.*;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;

public class Controller extends JPanel {

    private static final long serialVersionUID = 1L;
    private static final int STEP = 3;
    private static final int TIMER_DELAY = STEP * 8;
    private Map<Direction, Boolean> directionMap = new HashMap<Direction, Boolean>();

    private JLabel lblDirection = new JLabel();

    enum Direction {

        UP(KeyEvent.VK_UP), DOWN(KeyEvent.VK_DOWN),
        LEFT(KeyEvent.VK_LEFT), RIGHT(KeyEvent.VK_RIGHT);

        private int keyCode;

        private Direction(int keyCode) {
            this.keyCode = keyCode;
        }

        public int getKeyCode() {
            return keyCode;
        }
    }

    public Controller() {

        add(lblDirection);

        for (Direction direction : Direction.values()) {
            directionMap.put(direction, false);
        }
        setKeyBindings();
        Timer timer = new Timer(TIMER_DELAY, new TimerListener());
        timer.start();
    }

    private void setKeyBindings() {
        InputMap inMap = getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap actMap = getActionMap();
        for (final Direction direction : Direction.values()) {
            KeyStroke pressed = KeyStroke.getKeyStroke(direction.getKeyCode(), 0, false);
            KeyStroke released = KeyStroke.getKeyStroke(direction.getKeyCode(), 0, true);
            inMap.put(pressed, direction.toString() + "pressed");
            inMap.put(released, direction.toString() + "released");
            actMap.put(direction.toString() + "pressed", new AbstractAction() {

                private static final long serialVersionUID = 1L;

                @Override
                public void actionPerformed(ActionEvent e) {
                    directionMap.put(direction, true);
                }
            });
            actMap.put(direction.toString() + "released", new AbstractAction() {

                private static final long serialVersionUID = 1L;

                @Override
                public void actionPerformed(ActionEvent e) {
                    directionMap.put(direction, false);
                }
            });
        }
    }

    private class TimerListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            StringBuilder s = new StringBuilder("go ");
            for (Direction direction : Direction.values()) {
                if (directionMap.get(direction)) {
                    s.append(direction.name() + " ");
                }
            }
            lblDirection.setText(s.toString());
        }
    }

    public static void createAndShowUI() {
        JFrame frame = new JFrame("KeyMapping");
        frame.getContentPane().add(new Controller());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 80);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowUI();
            }
        });
    }
}