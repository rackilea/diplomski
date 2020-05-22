protected class ZoomButtonAction extends AbstractAction {
    public ZoomButtonAction(String text, String desc)
    {
        super(text);
        putValue(SHORT_DESCRIPTION, desc);
    }

    public void actionPerformed(ActionEvent e){

        ImageIcon icon = (ImageIcon)getValue(Action.SMALL_ICON);
        Image newImage = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        putValue(Action.SMALL_ICON, new ImageIcon(newImage));
    }
}