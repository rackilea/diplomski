/**
 * @see http://stackoverflow.com/q/12133795/230513
 */
public class NilBindingTest extends JPanel {

    private static final String NIL = "none";
    private Action nil = new AbstractAction(NIL) {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("\"" + e.getActionCommand() + "\"");
        }
    };
    private JButton button = new JButton(nil);
    //private InputMap im = button.getInputMap();
    private InputMap im = (InputMap) UIManager.get("Button.focusInputMap");

    public NilBindingTest() {
        this.add(new JButton("foo"));
        System.out.println(Arrays.toString(im.keys()));
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0), NIL);
        //button.getActionMap().put(NIL, nil);
        this.add(button);
    }

    private void display() {
        JFrame f = new JFrame("NilBindingTest");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(this);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new NilBindingTest().display();
            }
        });
    }
}