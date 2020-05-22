public static class ImagePreviewEditorPane extends ImagePreviewPane {

    private JTextField editor;

    public ImagePreviewEditorPane() {
        super();
        editor = new JTextField();
        remove(getDescriptionLabel());
        add(editor, BorderLayout.SOUTH);
    }

    @Override
    public void setDescription(String text) {
        editor.setText(text);
    }

    public String getDescription() {
        return editor.getText();
    }

    public void setImagePreview(ImagePreview preview) {
        setImage(preview.getImage());
        setDescription(preview.getDescription());
    }

    @Override
    public void addNotify() {
        super.addNotify();
        editor.requestFocusInWindow();
    }

}