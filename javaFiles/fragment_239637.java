dateEditor.getTextField().setEditable(false);
dateEditor.getTextField().addCaretListener(new CaretListener() {
    @Override
    public void caretUpdate(CaretEvent e) {
        int pos = dateEditor.getTextField().getDocument().getLength();
        if (e.getDot() != pos) {
            dateEditor.getTextField().setCaretPosition(pos);
        }
    }
});