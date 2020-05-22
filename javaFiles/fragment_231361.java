public class KeyBoardTest extends JFrame {
    private KeyBoard keyBoard;
    private TextAreaFrame textAreaFrame;
    private LabelFrame labelFrame;

    public KeyBoardTest() {
        // TODO Auto-generated constructor stub
        // This is the keyboard that's on the screen
        keyBoard = new KeyBoard();
        textAreaFrame = new TextAreaFrame();
        labelFrame = new LabelFrame();

        add(labelFrame.getLabelPanel(), BorderLayout.PAGE_START);
        add(textAreaFrame.getAreaPanel(), BorderLayout.CENTER);
        add(keyBoard.getKeyboard(), BorderLayout.PAGE_END);

        // keyBoard.getKeyboard().setBackground(Color.GRAY);
        // labelFrame.getLabelPanel().setBackground(Color.GRAY);
        // labelFrame.getLabel().setForeground(Color.WHITE);
        // textAreaFrame.getAreaPanel().setBackground(Color.GRAY);
    }

 //...

public class TextAreaFrame {
private JTextArea textArea;
private JPanel areaPanel;
private JFrame frame;
private KeyBoard keyBoard;
private JButton[][] b;

public TextAreaFrame() {
    // TODO Auto-generated constructor stub
    areaPanel = new JPanel();
    // This one is not, but is the instance you are trying to
    // change...
    keyBoard = new KeyBoard();