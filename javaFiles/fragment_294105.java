public class SpinnerCustomSkin extends JFXSpinnerSkin {
    private SpinnerCustom control;
    private DecimalFormat formatter = new DecimalFormat("0.00");

    public SpinnerCustomSkin(SpinnerCustom control) {
        super(control);

        this.control = control;
    }

    @Override
    protected void layoutChildren(double contentX, double contentY, double contentWidth, double contentHeight) {
        super.layoutChildren(contentX, contentY, contentWidth, contentHeight);

        Text text = ((Text) getNode().lookup("Text"));
        text.setText(formatter.format(control.getProgress())); //Or whatever you want to display
        text.relocate((control.getRadius() - text.getLayoutBounds().getWidth()) / 2, (control.getRadius() - text.getLayoutBounds().getHeight()) / 2);
    }
}