public static class UnderlineAction extends StyledTextAction {

    /**
     * Constructs a new UnderlineAction.
     */
    public UnderlineAction() {
        super("font-underline");
    }

    /**
     * Toggles the Underline attribute.
     *
     * @param e the action event
     */
    public void actionPerformed(ActionEvent e) {
        JEditorPane editor = getEditor(e);
        if (editor != null) {
            StyledEditorKit kit = getStyledEditorKit(editor);
            MutableAttributeSet attr = kit.getInputAttributes();
            boolean underline = (StyleConstants.isUnderline(attr)) ? false : true;
            SimpleAttributeSet sas = new SimpleAttributeSet();
            StyleConstants.setUnderline(sas, underline);
            setCharacterAttributes(editor, sas, false);
        }
    }
}