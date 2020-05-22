public class ImagePreviewPane extends JPanel {

    private JLabel imageLabel = new JLabel();
    private JLabel descriptionLabel = new JLabel();

    public ImagePreviewPane() {
        setLayout(new BorderLayout());
        Border emptyBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
        imageLabel.setBorder(emptyBorder);
        descriptionLabel.setBorder(emptyBorder);
        add(imageLabel, BorderLayout.CENTER);
        add(descriptionLabel, BorderLayout.SOUTH);
    }

    protected JLabel getDescriptionLabel() {
        return descriptionLabel;
    }

    protected JLabel getImageLabel() {
        return imageLabel;
    }

    public void setImage(ImageIcon icon) {
        imageLabel.setIcon(icon);
    }

    public void setDescription(String text) {
        descriptionLabel.setText(text);
    }

}