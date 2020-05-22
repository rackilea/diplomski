public class JTextFieldWithMenu extends JFrame implements DocumentListener {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private JTextField entry;
    private JLabel jLabel1;
    private JPopupMenu popup;

    public JTextFieldWithMenu() {
        initComponents();

        entry.getDocument().addDocumentListener(this);

    }

    private void initComponents() {
        entry = new JTextField(40);
        entry.addFocusListener(new FocusListener() {
            @Override
            public void focusLost(FocusEvent e) {
            }

            @Override
            public void focusGained(FocusEvent e) {
                entry.setSelectionStart(0);
                entry.setSelectionEnd(0);
                entry.setCaretPosition(entry.getText().length());
            }
        });
        jLabel1 = new JLabel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("TextFieldDemo");

        jLabel1.setText("Enter text to search:");
        setLayout(new BorderLayout());
        add(jLabel1, BorderLayout.WEST);
        add(entry, BorderLayout.CENTER);
        pack();
    }

    public void insertUpdate(DocumentEvent ev) {
        showPopup();
    }

    protected void showPopup() {
        if (popup != null)
            popup.setVisible(false);
        popup = null;
        if (entry.getText().length() == 0)
            return;
        popup = new JPopupMenu();
        popup.setRequestFocusEnabled(false);
        if (entry.getText().length() == 0) {
            popup.setVisible(false);
        } else {
            popup.removeAll();
            popup.add(new JMenuItem("Search for '" + entry.getText() + "' in Filter1"));
            popup.add(new JMenuItem("Search for '" + entry.getText() + "' in Filter2"));
            popup.add(new JMenuItem("Search for '" + entry.getText() + "' in Filter3"));
            if (!popup.isShowing())
                popup.show(entry, 0, entry.getHeight());
            else
                popup.revalidate();
            entry.requestFocus();
        }
    }

    public void removeUpdate(DocumentEvent ev) {
        showPopup();
    }

    public void changedUpdate(DocumentEvent ev) {
        showPopup();
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new JTextFieldWithMenu().setVisible(true);
            }
        });
    }

}