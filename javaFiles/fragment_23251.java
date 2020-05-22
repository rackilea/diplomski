public class MyButton { 

    private final Label buttonLabel;

    public MyButton(final Composite parent, final Theme theme) {
        buttonLabel = new Label(parent, SWT.NONE);
        buttonLabel.setImage(theme.getUpImage());
        buttonLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseDown(final MouseEvent mouseEvent) {
                buttonLabel.setImage(theme.getButtonPressedImage());
            }
            @Override
            public void mouseUp(final MouseEvent mouseEvent) {
                buttonLabel.setImage(theme.getButtonUpImage());
            }
        });
        buttonLabel.addMouseTrackListener(new MouseTrackAdapter() {
            @Override
            public void mouseEnter(final MouseEvent mouseEvent) {
                buttonLabel.setImage(theme.getButtonHoverImage());
            }
            @Override
            public void mouseExit(final MouseEvent mouseEvent) {
                buttonLabel.setImage(theme.getButtonUpImage());
            }
        });
    }

}