public class KeyBoardTest extends JFrame {

    private KeyBoard keyBoard;
    private TextAreaFrame textAreaFrame;
    private LabelFrame labelFrame;

    public KeyBoardTest() {
        // TODO Auto-generated constructor stub
        keyBoard = new KeyBoard();
        textAreaFrame = new TextAreaFrame(keyBoard);
        labelFrame = new LabelFrame();

//...

public class TextAreaFrame {

    private JTextArea textArea;
    private JPanel areaPanel;
    private JFrame frame;
    private KeyBoard keyBoard;
    private JButton[][] b;

    public TextAreaFrame(KeyBoard keyBoard) {
        // TODO Auto-generated constructor stub
        areaPanel = new JPanel();
        this.keyBoard = keyBoard;