You can use below code to implement Redo.

public class TextAreaDemoB extends JFrame {
private UndoManager undoManager;
JTextArea _resultArea = new JTextArea(6, 20);

public TextAreaDemoB() {
    JScrollPane scrollingArea = new JScrollPane(_resultArea);

    JPanel content = new JPanel();
    content.setLayout(new BorderLayout());
    content.add(scrollingArea, BorderLayout.CENTER);

    this.setContentPane(content);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.pack();

    undoManager = new UndoManager();
    Document doc_ = _resultArea.getDocument();
    doc_.addUndoableEditListener(new UndoableEditListener() {
        @Override
        public void undoableEditHappened(UndoableEditEvent e) {

            undoManager.addEdit(e.getEdit());

        }
    });
    InputMap im = _resultArea.getInputMap(JComponent.WHEN_FOCUSED);
    ActionMap am = _resultArea.getActionMap();

    im.put(KeyStroke.getKeyStroke(KeyEvent.VK_Z, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()), "Undo");
    im.put(KeyStroke.getKeyStroke(KeyEvent.VK_Y, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()), "Redo");

    am.put("Undo", new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                if (undoManager.canUndo()) {
                    undoManager.undo();
                }
            } catch (CannotUndoException exp) {
                exp.printStackTrace();
            }
        }
    });
    am.put("Redo", new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                if (undoManager.canRedo()) {
                    undoManager.redo();
                }
            } catch (CannotUndoException exp) {
                exp.printStackTrace();
            }
        }
    });
}
public static void main(String[] args) {
    JFrame win = new TextAreaDemoB();
    win.setVisible(true);
}
}