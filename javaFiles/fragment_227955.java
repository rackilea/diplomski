public class Test_1 implements KeyListener {

static boolean spacedPressed = false;
static JTextField text = new JTextField();

public static void main(String s[]) {

    JFrame frame = new JFrame("JFrame Test");

    JPanel panel = new JPanel();
    panel.setLayout(new FlowLayout());

    JLabel label = new JLabel("Test Label");

    JButton button = new JButton();
    button.setText("Press me");
    frame.addKeyListener(new Test_1());

    panel.add(label);
    //      panel.add(button);

    frame.add(panel);
    frame.setSize(300, 300);
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);

    if (button.getModel().isPressed()) {
        System.out.println("pressed");
        panel.add(text);
        System.out.println(spacedPressed);
    }
}

@Override
public void keyPressed(KeyEvent e) {
    if (e.getKeyCode() == KeyEvent.VK_SPACE) {
        System.out.println("Pressed");
        spacedPressed = true;
        text.setText("Press worked.");
    } else {
        System.out.println("not pressed");
        text.setText("Press didn't work.");
        spacedPressed = false;
    }
}

@Override
public void keyReleased(KeyEvent e) {
    System.out.println("Released");
}

@Override
public void keyTyped(KeyEvent e) {
    System.out.println("Typed");
}
}