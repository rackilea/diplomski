public class ImagePreviewListCellEditor extends AbstactListCellEditor<ImagePreview> {

    private ImagePreviewEditorPane previewPane;

    public ImagePreviewListCellEditor() {
        previewPane = new ImagePreviewEditorPane();
        InputMap im = previewPane.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "accept");
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "cancel");

        ActionMap am = previewPane.getActionMap();
        am.put("accept", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stopCellEditing();
            }
        });
        am.put("cancel", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cancelCellEditing();
            }
        });
    }

    public void applyEditorValue(ImagePreview preview) {
        preview.setDescription(previewPane.getDescription());
    }

    @Override
    public Component getListCellEditorComponent(JList<ImagePreview> list, ImagePreview value, boolean isSelected, int index) {

        Color bg = null;
        Color fg = null;

        JList.DropLocation dropLocation = list.getDropLocation();
        if (dropLocation != null
                && !dropLocation.isInsert()
                && dropLocation.getIndex() == index) {

            bg = DefaultLookup.getColor(previewPane, previewPane.getUI(), "List.dropCellBackground");
            fg = DefaultLookup.getColor(previewPane, previewPane.getUI(), "List.dropCellForeground");

            isSelected = true;
        }

        if (isSelected) {
            previewPane.setBackground(bg == null ? list.getSelectionBackground() : bg);
            previewPane.setForeground(fg == null ? list.getSelectionForeground() : fg);
        } else {
            previewPane.setBackground(list.getBackground());
            previewPane.setForeground(list.getForeground());
        }

        if (value instanceof ImagePreview) {
            ImagePreview preview = (ImagePreview)value;
            previewPane.setImagePreview(preview);
        } else {
            previewPane.setImagePreview(null);
        }

        return previewPane;
    }

}