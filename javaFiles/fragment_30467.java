public class Frame {

public static void main(String[] args) {            
    JFrame frame = new JFrame();
    frame.setSize(600, 400);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setLayout(new GridLayout(1, 2, 1, 1));

    JPanel panel = new JPanel();
    panel.setLayout(new GridLayout(2, 1, 1, 1));

    frame.add(panel, BorderLayout.CENTER);

    JPanel center = new JPanel();
    center.setLayout(new GridLayout(9, 9, 1, 1));

    for(int i = 0; i < 6; i++) {
        for(int j = 0; j < 6; j++) {

            JButton button = new JButton(Integer.toString(random(1, 6)));
            center.add(button);
        }
    }
    frame.add(center, BorderLayout.CENTER);
    frame.setVisible(true);
}

private static int random(int min, int max) {
    return (int) (Math.random() * (max - min) + min);
        }
}