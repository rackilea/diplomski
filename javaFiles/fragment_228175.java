public class TextAreaComboBoxEditor implements ComboBoxEditor {

    private JTextArea ta = new JTextArea(4, 20);
    private JScrollPane sp = new JScrollPane(ta);

    public TextAreaComboBoxEditor() {
        ta.setWrapStyleWord(true);
        ta.setLineWrap(true);
    }

    @Override
    public Component getEditorComponent() {
        return sp;
    }

    @Override
    public void setItem(Object anObject) {
        if (anObject instanceof String) {
            ta.setText((String) anObject);
        } else {
            ta.setText(null);
        }
    }

    @Override
    public Object getItem() {
        return ta.getText();
    }

    @Override
    public void selectAll() {
        ta.selectAll();
    }

    @Override
    public void addActionListener(ActionListener l) {
    }

    @Override
    public void removeActionListener(ActionListener l) {
    }

}